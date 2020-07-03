package pers.ccy.ssatweb.service.impl;

import org.springframework.beans.BeanUtils;
import pers.ccy.ssatweb.domain.SsatPermission;
import pers.ccy.ssatweb.dao.SsatPermissionDao;
import pers.ccy.ssatweb.domain.SsatPermissionNode;
import pers.ccy.ssatweb.service.SsatPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (SsatPermission)表服务实现类
 *
 * @author makejava
 * @since 2020-07-03 15:10:22
 */
@Service("ssatPermissionService")
public class SsatPermissionServiceImpl implements SsatPermissionService {
    @Resource
    private SsatPermissionDao ssatPermissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SsatPermission queryById(Long id) {
        return this.ssatPermissionDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SsatPermission> queryAllByLimit(int offset, int limit) {
        return this.ssatPermissionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param ssatPermission 实例对象
     * @return 实例对象
     */
    @Override
    public SsatPermission insert(SsatPermission ssatPermission) {
        this.ssatPermissionDao.insert(ssatPermission);
        return ssatPermission;
    }

    /**
     * 修改数据
     *
     * @param ssatPermission 实例对象
     * @return 实例对象
     */
    @Override
    public SsatPermission update(SsatPermission ssatPermission) {
        this.ssatPermissionDao.update(ssatPermission);
        return this.queryById(ssatPermission.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.ssatPermissionDao.deleteById(id) > 0;
    }

    @Override
    public List<SsatPermissionNode> treeList() {
        List<SsatPermission> permissionList = ssatPermissionDao.queryAll(new SsatPermission());
        List<SsatPermissionNode> result = permissionList.stream()
                .filter(permission -> permission.getPid().equals(0L))
                .map(permission -> covert(permission,permissionList)).collect(Collectors.toList());
        return result;
    }

    /**
     * 将权限转换为带有子级的权限对象
     * 当找不到子级权限的时候map操作不会再递归调用covert
     */
    private SsatPermissionNode covert(SsatPermission permission, List<SsatPermission> permissionList){
        SsatPermissionNode node = new SsatPermissionNode();
        BeanUtils.copyProperties(permission,node);
        List<SsatPermissionNode> children = permissionList.stream()
                .filter(subPermission -> subPermission.getPid().equals(permission.getId()))
                .map(subPermission -> covert(subPermission,permissionList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }
}