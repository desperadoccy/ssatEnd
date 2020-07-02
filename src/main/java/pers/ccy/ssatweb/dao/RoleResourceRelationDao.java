package pers.ccy.ssatweb.dao;

import pers.ccy.ssatweb.domain.RoleResourceRelation;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (RoleResourceRelation)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-02 09:19:42
 */
public interface RoleResourceRelationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RoleResourceRelation queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RoleResourceRelation> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param roleResourceRelation 实例对象
     * @return 对象列表
     */
    List<RoleResourceRelation> queryAll(RoleResourceRelation roleResourceRelation);

    /**
     * 新增数据
     *
     * @param roleResourceRelation 实例对象
     * @return 影响行数
     */
    int insert(RoleResourceRelation roleResourceRelation);

    /**
     * 修改数据
     *
     * @param roleResourceRelation 实例对象
     * @return 影响行数
     */
    int update(RoleResourceRelation roleResourceRelation);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}