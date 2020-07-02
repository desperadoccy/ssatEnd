package pers.ccy.ssatweb.dao;

import pers.ccy.ssatweb.domain.RoleMenuRelation;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (RoleMenuRelation)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-02 09:18:41
 */
public interface RoleMenuRelationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RoleMenuRelation queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RoleMenuRelation> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param roleMenuRelation 实例对象
     * @return 对象列表
     */
    List<RoleMenuRelation> queryAll(RoleMenuRelation roleMenuRelation);

    /**
     * 新增数据
     *
     * @param roleMenuRelation 实例对象
     * @return 影响行数
     */
    int insert(RoleMenuRelation roleMenuRelation);

    /**
     * 修改数据
     *
     * @param roleMenuRelation 实例对象
     * @return 影响行数
     */
    int update(RoleMenuRelation roleMenuRelation);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}