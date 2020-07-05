package pers.ccy.ssatweb.service;

import pers.ccy.ssatweb.domain.RolePermissionRelation;
import java.util.List;

/**
 * (RolePermissionRelation)表服务接口
 *
 * @author makejava
 * @since 2020-07-02 23:10:15
 */
public interface RolePermissionRelationService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RolePermissionRelation queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RolePermissionRelation> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param rolePermissionRelation 实例对象
     * @return 实例对象
     */
    RolePermissionRelation insert(RolePermissionRelation rolePermissionRelation);

    /**
     * 修改数据
     *
     * @param rolePermissionRelation 实例对象
     * @return 实例对象
     */
    RolePermissionRelation update(RolePermissionRelation rolePermissionRelation);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}