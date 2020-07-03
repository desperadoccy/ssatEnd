package pers.ccy.ssatweb.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import pers.ccy.ssatweb.dao.RolePermissionRelationDao;
import pers.ccy.ssatweb.dao.RoleResourceRelationDao;
import pers.ccy.ssatweb.domain.*;
import pers.ccy.ssatweb.dao.SsatRoleDao;
import pers.ccy.ssatweb.service.SsatRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (SsatRole)表服务实现类
 *
 * @author makejava
 * @since 2020-07-02 09:24:28
 */
@Service("ssatRoleService")
public class SsatRoleServiceImpl implements SsatRoleService {
    @Resource
    private SsatRoleDao ssatRoleDao;
    @Autowired
    private RolePermissionRelationDao rolePermissionRelationDao;
    @Autowired
    private RoleResourceRelationDao roleResourceRelationDao;

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
}