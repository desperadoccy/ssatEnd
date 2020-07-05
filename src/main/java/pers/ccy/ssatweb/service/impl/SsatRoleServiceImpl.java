package pers.ccy.ssatweb.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import pers.ccy.ssatweb.dao.RolePermissionRelationDao;
import pers.ccy.ssatweb.dao.RoleResourceRelationDao;
import pers.ccy.ssatweb.dao.SsatResourceDao;
import pers.ccy.ssatweb.domain.*;
import pers.ccy.ssatweb.dao.SsatRoleDao;
import pers.ccy.ssatweb.service.SsatRoleService;
import org.springframework.stereotype.Service;
import pers.ccy.ssatweb.vo.SsatResourceVO;
import pers.ccy.ssatweb.vo.SsatRoleVO;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (SsatRole)表服务实现类
 *
 * @author makejava
 * @since 2020-07-02 09:24:28
 */
@Transactional
@Service("ssatRoleService")
public class SsatRoleServiceImpl implements SsatRoleService {
    @Resource
    private SsatRoleDao ssatRoleDao;
    @Autowired
    private RolePermissionRelationDao rolePermissionRelationDao;
    @Autowired
    private RoleResourceRelationDao roleResourceRelationDao;
    @Autowired
    private SsatResourceDao ssatResourceDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SsatRole queryById(Long id) {
        return this.ssatRoleDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SsatRole> queryAllByLimit(int offset, int limit) {
        return this.ssatRoleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param ssatRole 实例对象
     * @return 实例对象
     */
    @Override
    public SsatRole insert(SsatRole ssatRole) {
        this.ssatRoleDao.insert(ssatRole);
        return ssatRole;
    }

    /**
     * 修改数据
     *
     * @param ssatRole 实例对象
     * @return 实例对象
     */
    @Override
    public SsatRole update(SsatRole ssatRole) {
        this.ssatRoleDao.update(ssatRole);
        return this.queryById(ssatRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.ssatRoleDao.deleteById(id) > 0;
    }

    @Override
    public List<SsatPermission> getPermissionList(Long roleId) {
        return rolePermissionRelationDao.getPermissionList(roleId);
    }

    @Override
    public int updatePermission(Long roleId, List<Long> permissionIds) {
        //先删除原有关系
        rolePermissionRelationDao.deleteByRoleId(roleId);
        //批量插入新关系
        List<RolePermissionRelation> relationList = new ArrayList<>();
        for (Long permissionId : permissionIds) {
            RolePermissionRelation relation = new RolePermissionRelation();
            relation.setRoleId(roleId);
            relation.setPermissionId(permissionId);
            rolePermissionRelationDao.insert(relation);
        }
        return 1;
    }

    @Override
    public List<SsatRole> list() {
        return ssatRoleDao.queryAll(new SsatRole());
    }

    @Override
    public List<SsatRole> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        if (!StringUtils.isEmpty(keyword)) {
            String query  = "%" + keyword + "%";
            return ssatRoleDao.queryByName(query);
        }
        return null;
    }

    @Override
    public List<SsatResource> listResource(Long roleId) {
        return ssatRoleDao.getResourceListByRoleId(roleId);
    }

    @Override
    public int allocResource(Long roleId, List<Long> resourceIds) {
        //先删除原有关系
        roleResourceRelationDao.deleteByRoleId(roleId);
        //批量插入新关系
        for (Long resourceId : resourceIds) {
            RoleResourceRelation relation = new RoleResourceRelation();
            relation.setRoleId(roleId);
            relation.setResourceId(resourceId);
            roleResourceRelationDao.insert(relation);
        }
        return resourceIds.size();
    }

    @Override
    public List<SsatRoleVO> listAll() {
        List<SsatRole> list = list();
        List<SsatRoleVO> roleVoList = new ArrayList<>();
        List<SsatResourceVO> resources = null;
        for (SsatRole role: list){
            Map<String,List<SsatResourceVO>> category = new HashMap<>();
            List<SsatResourceVO> resourceList = ssatResourceDao.selectByRoleId(role.getId());
            if (resourceList.size() == 0) {
                SsatRoleVO roleVO = SsatRoleVO.parseBy(role, category);
                roleVoList.add(roleVO);
                continue;
            }
            for (SsatResourceVO resource: resourceList){
                if (!category.containsKey(resource.getCategoryName())){
                    if (!category.isEmpty())
                        category.put(resources.get(0).getCategoryName(),resources);
                    category.put(resource.getCategoryName(),null);
                    resources = new ArrayList<>();
                }
                resources.add(resource);
            }
            category.put(resources.get(0).getCategoryName(),resources);
            SsatRoleVO roleVO = SsatRoleVO.parseBy(role, category);
            roleVoList.add(roleVO);
        }
        return roleVoList;
    }

    @Override
    public List<Long> listAllResourceIds(Long roleId) {
        return ssatResourceDao.listAllResourceIds(roleId);
    }
}