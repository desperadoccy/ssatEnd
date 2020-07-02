package pers.ccy.ssatweb.service.impl;

import pers.ccy.ssatweb.domain.RoleMenuRelation;
import pers.ccy.ssatweb.dao.RoleMenuRelationDao;
import pers.ccy.ssatweb.service.RoleMenuRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (RoleMenuRelation)表服务实现类
 *
 * @author makejava
 * @since 2020-07-02 09:19:06
 */
@Service("roleMenuRelationService")
public class RoleMenuRelationServiceImpl implements RoleMenuRelationService {
    @Resource
    private RoleMenuRelationDao roleMenuRelationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RoleMenuRelation queryById(Long id) {
        return this.roleMenuRelationDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<RoleMenuRelation> queryAllByLimit(int offset, int limit) {
        return this.roleMenuRelationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param roleMenuRelation 实例对象
     * @return 实例对象
     */
    @Override
    public RoleMenuRelation insert(RoleMenuRelation roleMenuRelation) {
        this.roleMenuRelationDao.insert(roleMenuRelation);
        return roleMenuRelation;
    }

    /**
     * 修改数据
     *
     * @param roleMenuRelation 实例对象
     * @return 实例对象
     */
    @Override
    public RoleMenuRelation update(RoleMenuRelation roleMenuRelation) {
        this.roleMenuRelationDao.update(roleMenuRelation);
        return this.queryById(roleMenuRelation.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.roleMenuRelationDao.deleteById(id) > 0;
    }
}