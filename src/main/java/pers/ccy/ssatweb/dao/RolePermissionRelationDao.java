package pers.ccy.ssatweb.dao;

import org.apache.ibatis.annotations.Mapper;
import pers.ccy.ssatweb.domain.RolePermissionRelation;
import org.apache.ibatis.annotations.Param;
import pers.ccy.ssatweb.domain.SsatPermission;

import java.util.List;

/**
 * (RolePermissionRelation)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-02 23:10:15
 */
@Mapper
public interface RolePermissionRelationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RolePermissionRelation queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RolePermissionRelation> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param rolePermissionRelation 实例对象
     * @return 对象列表
     */
    List<RolePermissionRelation> queryAll(RolePermissionRelation rolePermissionRelation);

    /**
     * 新增数据
     *
     * @param rolePermissionRelation 实例对象
     * @return 影响行数
     */
    int insert(RolePermissionRelation rolePermissionRelation);

    /**
     * 修改数据
     *
     * @param rolePermissionRelation 实例对象
     * @return 影响行数
     */
    int update(RolePermissionRelation rolePermissionRelation);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);
    List<SsatPermission> getPermissionList(Long roleId);
    int deleteByRoleId(Long roleId);
}