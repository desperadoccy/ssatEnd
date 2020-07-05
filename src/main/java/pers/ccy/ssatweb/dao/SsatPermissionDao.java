package pers.ccy.ssatweb.dao;

import org.apache.ibatis.annotations.Mapper;
import pers.ccy.ssatweb.domain.SsatPermission;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (SsatPermission)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-03 15:10:22
 */
@Mapper
public interface SsatPermissionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SsatPermission queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SsatPermission> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param ssatPermission 实例对象
     * @return 对象列表
     */
    List<SsatPermission> queryAll(SsatPermission ssatPermission);

    /**
     * 新增数据
     *
     * @param ssatPermission 实例对象
     * @return 影响行数
     */
    int insert(SsatPermission ssatPermission);

    /**
     * 修改数据
     *
     * @param ssatPermission 实例对象
     * @return 影响行数
     */
    int update(SsatPermission ssatPermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}