package pers.ccy.ssatweb.dao;

import org.apache.ibatis.annotations.Mapper;
import pers.ccy.ssatweb.domain.SsatResource;
import org.apache.ibatis.annotations.Param;
import pers.ccy.ssatweb.vo.SsatResourceVO;

import java.util.List;

/**
 * (SsatResource)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-02 09:24:13
 */
@Mapper
public interface SsatResourceDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SsatResource queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SsatResource> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param ssatResource 实例对象
     * @return 对象列表
     */
    List<SsatResource> queryAll(SsatResource ssatResource);

    /**
     * 新增数据
     *
     * @param ssatResource 实例对象
     * @return 影响行数
     */
    int insert(SsatResource ssatResource);

    /**
     * 修改数据
     *
     * @param ssatResource 实例对象
     * @return 影响行数
     */
    int update(SsatResource ssatResource);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    List<SsatResourceVO> selectByRoleId(Long roleId);

    List<SsatResourceVO> queryAllWithCategory(SsatResource ssatResource);

    List<Long> listAllResourceIds(Long roleId);
}