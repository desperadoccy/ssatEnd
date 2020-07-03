package pers.ccy.ssatweb.service.impl;

import pers.ccy.ssatweb.domain.AdminPermissionRelation;
import pers.ccy.ssatweb.dao.AdminPermissionRelationDao;
import pers.ccy.ssatweb.service.AdminPermissionRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AdminPermissionRelation)表服务实现类
 *
 * @author makejava
 * @since 2020-07-02 23:17:25
 */
@Service("adminPermissionRelationService")
public class AdminPermissionRelationServiceImpl implements AdminPermissionRelationService {
    @Resource
    private AdminPermissionRelationDao adminPermissionRelationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AdminPermissionRelation queryById(Long id) {
        return this.adminPermissionRelationDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<AdminPermissionRelation> queryAllByLimit(int offset, int limit) {
        return this.adminPermissionRelationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param adminPermissionRelation 实例对象
     * @return 实例对象
     */
    @Override
    public AdminPermissionRelation insert(AdminPermissionRelation adminPermissionRelation) {
        this.adminPermissionRelationDao.insert(adminPermissionRelation);
        return adminPermissionRelation;
    }

    /**
     * 修改数据
     *
     * @param adminPermissionRelation 实例对象
     * @return 实例对象
     */
    @Override
    public AdminPermissionRelation update(AdminPermissionRelation adminPermissionRelation) {
        this.adminPermissionRelationDao.update(adminPermissionRelation);
        return this.queryById(adminPermissionRelation.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.adminPermissionRelationDao.deleteById(id) > 0;
    }
}