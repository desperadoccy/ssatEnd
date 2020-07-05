package pers.ccy.ssatweb.service;

import pers.ccy.ssatweb.domain.AdminPermissionRelation;
import java.util.List;

/**
 * (AdminPermissionRelation)表服务接口
 *
 * @author makejava
 * @since 2020-07-02 23:17:25
 */
public interface AdminPermissionRelationService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AdminPermissionRelation queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AdminPermissionRelation> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param adminPermissionRelation 实例对象
     * @return 实例对象
     */
    AdminPermissionRelation insert(AdminPermissionRelation adminPermissionRelation);

    /**
     * 修改数据
     *
     * @param adminPermissionRelation 实例对象
     * @return 实例对象
     */
    AdminPermissionRelation update(AdminPermissionRelation adminPermissionRelation);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}