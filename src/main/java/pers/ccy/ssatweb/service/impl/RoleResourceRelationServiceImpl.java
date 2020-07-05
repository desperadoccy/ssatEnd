package pers.ccy.ssatweb.service.impl;

import org.springframework.transaction.annotation.Transactional;
import pers.ccy.ssatweb.domain.RoleResourceRelation;
import pers.ccy.ssatweb.dao.RoleResourceRelationDao;
import pers.ccy.ssatweb.service.RoleResourceRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (RoleResourceRelation)表服务实现类
 *
 * @author makejava
 * @since 2020-07-02 09:19:42
 */
@Transactional
@Service("roleResourceRelationService")
public class RoleResourceRelationServiceImpl implements RoleResourceRelationService {
    @Resource
    private RoleResourceRelationDao roleResourceRelationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RoleResourceRelation queryById(Long id) {
        return this.roleResourceRelationDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<RoleResourceRelation> queryAllByLimit(int offset, int limit) {
        return this.roleResourceRelationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param roleResourceRelation 实例对象
     * @return 实例对象
     */
    @Override
    public RoleResourceRelation insert(RoleResourceRelation roleResourceRelation) {
        this.roleResourceRelationDao.insert(roleResourceRelation);
        return roleResourceRelation;
    }

    /**
     * 修改数据
     *
     * @param roleResourceRelation 实例对象
     * @return 实例对象
     */
    @Override
    public RoleResourceRelation update(RoleResourceRelation roleResourceRelation) {
        this.roleResourceRelationDao.update(roleResourceRelation);
        return this.queryById(roleResourceRelation.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.roleResourceRelationDao.deleteById(id) > 0;
    }

    @Override
    public boolean delete(Long roleId, Long resourceId) {
        return roleResourceRelationDao.delete(roleId,resourceId);
    }


}