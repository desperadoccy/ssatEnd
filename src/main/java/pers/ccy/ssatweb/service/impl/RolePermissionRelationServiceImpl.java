package pers.ccy.ssatweb.service.impl;

import pers.ccy.ssatweb.dao.RolePermissionRelationDao;
import pers.ccy.ssatweb.domain.RolePermissionRelation;
import pers.ccy.ssatweb.service.RolePermissionRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (RolePermissionRelation)表服务实现类
 *
 * @author makejava
 * @since 2020-07-02 23:10:15
 */
@Service("rolePermissionRelationService")
public class RolePermissionRelationServiceImpl implements RolePermissionRelationService {
    @Resource
    private RolePermissionRelationDao rolePermissionRelationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RolePermissionRelation queryById(Long id) {
        return this.rolePermissionRelationDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<RolePermissionRelation> queryAllByLimit(int offset, int limit) {
        return this.rolePermissionRelationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param rolePermissionRelation 实例对象
     * @return 实例对象
     */
    @Override
    public RolePermissionRelation insert(RolePermissionRelation rolePermissionRelation) {
        this.rolePermissionRelationDao.insert(rolePermissionRelation);
        return rolePermissionRelation;
    }

    /**
     * 修改数据
     *
     * @param rolePermissionRelation 实例对象
     * @return 实例对象
     */
    @Override
    public RolePermissionRelation update(RolePermissionRelation rolePermissionRelation) {
        this.rolePermissionRelationDao.update(rolePermissionRelation);
        return this.queryById(rolePermissionRelation.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.rolePermissionRelationDao.deleteById(id) > 0;
    }
}