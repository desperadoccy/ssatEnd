package pers.ccy.ssatweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pers.ccy.ssatweb.dao.SsatRoleDao;
import pers.ccy.ssatweb.domain.AdminRoleRelation;
import pers.ccy.ssatweb.dao.AdminRoleRelationDao;
import pers.ccy.ssatweb.domain.SsatRole;
import pers.ccy.ssatweb.service.AdminRoleRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AdminRoleRelation)表服务实现类
 *
 * @author makejava
 * @since 2020-07-02 09:22:36
 */
@Transactional
@Service("adminRoleRelationService")
public class AdminRoleRelationServiceImpl implements AdminRoleRelationService {
    @Resource
    private AdminRoleRelationDao adminRoleRelationDao;
    @Autowired
    private SsatRoleDao ssatRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AdminRoleRelation queryById(Long id) {
        return this.adminRoleRelationDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<AdminRoleRelation> queryAllByLimit(int offset, int limit) {
        return this.adminRoleRelationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param adminRoleRelation 实例对象
     * @return 实例对象
     */
    @Override
    public AdminRoleRelation insert(AdminRoleRelation adminRoleRelation) {
        this.adminRoleRelationDao.insert(adminRoleRelation);
        return adminRoleRelation;
    }

    /**
     * 修改数据
     *
     * @param adminRoleRelation 实例对象
     * @return 实例对象
     */
    @Override
    public AdminRoleRelation update(AdminRoleRelation adminRoleRelation) {
        this.adminRoleRelationDao.update(adminRoleRelation);
        return this.queryById(adminRoleRelation.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.adminRoleRelationDao.deleteById(id) > 0;
    }

    @Override
    public void updateRole(Long userId, Long roleId) {
        AdminRoleRelation preRole = adminRoleRelationDao.queryByUserId(userId);
        int flag = adminRoleRelationDao.updateRole(userId, roleId);
        ssatRoleDao.addCount(roleId);
        if (flag == 0){
            AdminRoleRelation relation = new AdminRoleRelation();
            relation.setAdminId(userId);
            relation.setRoleId(roleId);
            adminRoleRelationDao.insert(relation);
        } else {
            ssatRoleDao.subCount(preRole.getRoleId());
        }
    }
}