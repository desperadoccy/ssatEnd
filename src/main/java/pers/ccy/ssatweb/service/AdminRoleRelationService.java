package pers.ccy.ssatweb.service;

import pers.ccy.ssatweb.domain.AdminRoleRelation;
import java.util.List;

/**
 * (AdminRoleRelation)表服务接口
 *
 * @author makejava
 * @since 2020-07-02 09:22:36
 */
public interface AdminRoleRelationService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AdminRoleRelation queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AdminRoleRelation> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param adminRoleRelation 实例对象
     * @return 实例对象
     */
    AdminRoleRelation insert(AdminRoleRelation adminRoleRelation);

    /**
     * 修改数据
     *
     * @param adminRoleRelation 实例对象
     * @return 实例对象
     */
    AdminRoleRelation update(AdminRoleRelation adminRoleRelation);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    void updateRole(Long userId,Long roleId);
}