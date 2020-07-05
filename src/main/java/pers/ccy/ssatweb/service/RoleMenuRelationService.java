package pers.ccy.ssatweb.service;

import pers.ccy.ssatweb.domain.RoleMenuRelation;
import java.util.List;

/**
 * (RoleMenuRelation)表服务接口
 *
 * @author makejava
 * @since 2020-07-02 09:18:55
 */
public interface RoleMenuRelationService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RoleMenuRelation queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RoleMenuRelation> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param roleMenuRelation 实例对象
     * @return 实例对象
     */
    RoleMenuRelation insert(RoleMenuRelation roleMenuRelation);

    /**
     * 修改数据
     *
     * @param roleMenuRelation 实例对象
     * @return 实例对象
     */
    RoleMenuRelation update(RoleMenuRelation roleMenuRelation);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}