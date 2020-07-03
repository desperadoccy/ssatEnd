package pers.ccy.ssatweb.dao;

import org.apache.ibatis.annotations.Mapper;
import pers.ccy.ssatweb.domain.AdminRoleRelation;
import org.apache.ibatis.annotations.Param;
import pers.ccy.ssatweb.domain.SsatPermission;
import pers.ccy.ssatweb.domain.SsatResource;
import pers.ccy.ssatweb.domain.SsatRole;

import java.util.List;

/**
 * (AdminRoleRelation)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-02 09:18:17
 */
@Mapper
public interface AdminRoleRelationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AdminRoleRelation queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AdminRoleRelation> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param adminRoleRelation 实例对象
     * @return 对象列表
     */
    List<AdminRoleRelation> queryAll(AdminRoleRelation adminRoleRelation);

    /**
     * 新增数据
     *
     * @param adminRoleRelation 实例对象
     * @return 影响行数
     */
    int insert(AdminRoleRelation adminRoleRelation);

    /**
     * 修改数据
     *
     * @param adminRoleRelation 实例对象
     * @return 影响行数
     */
    int update(AdminRoleRelation adminRoleRelation);

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

    /**
     * 通过adminId查询数据
     *
     * @param adminId
     * @return 结果
     */
    List<SsatResource> getResourceList(Long adminId);

    /**
     * 通过adminId查询权限列表
     *
     * @param adminId
     * @return 结果
     */
    List<SsatPermission> getRolePermissionList(Long adminId);

    /**
     * 通过adminId查询权限列表
     *
     * @param adminId
     * @return 结果
     */
    List<SsatPermission> getPermissionList(Long adminId);
}