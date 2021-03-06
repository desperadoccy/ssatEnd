package pers.ccy.ssatweb.dao;

import org.apache.ibatis.annotations.Mapper;
import pers.ccy.ssatweb.domain.SsatAdmin;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (SsatAdmin)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-02 09:23:17
 */
@Mapper
public interface SsatAdminDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SsatAdmin queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SsatAdmin> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param ssatAdmin 实例对象
     * @return 对象列表
     */
    List<SsatAdmin> queryAll(SsatAdmin ssatAdmin);

    /**
     * 新增数据
     *
     * @param ssatAdmin 实例对象
     * @return 影响行数
     */
    int insert(SsatAdmin ssatAdmin);

    /**
     * 修改数据
     *
     * @param ssatAdmin 实例对象
     * @return 影响行数
     */
    int update(SsatAdmin ssatAdmin);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 通过username查询数据
     *
     * @param username
     * @return 查询的数据
     */
    SsatAdmin getAdminByUsername(String username);

    /**
     * 模糊查询
     * @param username
     * @return
     */
    List<SsatAdmin> selectAdmin(String username);

    int updateStatus(Long userId,int status);
}