package pers.ccy.ssatweb.dao;

import org.apache.ibatis.annotations.Mapper;
import pers.ccy.ssatweb.domain.AdminPermissionRelation;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (AdminPermissionRelation)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-02 23:17:25
 */
@Mapper
public interface AdminPermissionRelationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AdminPermissionRelation queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AdminPermissionRelation> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param adminPermissionRelation 实例对象
     * @return 对象列表
     */
    List<AdminPermissionRelation> queryAll(AdminPermissionRelation adminPermissionRelation);

    /**
     * 新增数据
     *
     * @param adminPermissionRelation 实例对象
     * @return 影响行数
     */
    int insert(AdminPermissionRelation adminPermissionRelation);

    /**
     * 修改数据
     *
     * @param adminPermissionRelation 实例对象
     * @return 影响行数
     */
    int update(AdminPermissionRelation adminPermissionRelation);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 通过adminId删除数据
     *
     * @param adminId
     * @return 影响行数
     */
    int deleteByAdminId(Long adminId);
}