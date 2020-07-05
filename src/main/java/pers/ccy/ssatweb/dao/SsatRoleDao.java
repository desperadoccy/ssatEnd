package pers.ccy.ssatweb.dao;

import org.apache.ibatis.annotations.Mapper;
import pers.ccy.ssatweb.domain.SsatResource;
import pers.ccy.ssatweb.domain.SsatRole;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (SsatRole)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-02 09:24:28
 */
@Mapper
public interface SsatRoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SsatRole queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SsatRole> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param ssatRole 实例对象
     * @return 对象列表
     */
    List<SsatRole> queryAll(SsatRole ssatRole);

    /**
     * 新增数据
     *
     * @param ssatRole 实例对象
     * @return 影响行数
     */
    int insert(SsatRole ssatRole);

    /**
     * 修改数据
     *
     * @param ssatRole 实例对象
     * @return 影响行数
     */
    int update(SsatRole ssatRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);


    /**
     * 通过adminId查询数据
     *
     * @param adminId
     * @return 影响行数
     */
    List<SsatRole> queryByAdminId(Long adminId);
    List<SsatRole> queryByName(String keyword);
    List<SsatResource> getResourceListByRoleId(Long roleId);
    int count();
    void addCount(Long roleId);
    void subCount(Long roleId);
}