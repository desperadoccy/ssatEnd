package pers.ccy.ssatweb.service;

import pers.ccy.ssatweb.domain.RoleResourceRelation;
import java.util.List;

/**
 * (RoleResourceRelation)表服务接口
 *
 * @author makejava
 * @since 2020-07-02 09:19:42
 */
public interface RoleResourceRelationService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RoleResourceRelation queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RoleResourceRelation> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param roleResourceRelation 实例对象
     * @return 实例对象
     */
    RoleResourceRelation insert(RoleResourceRelation roleResourceRelation);

    /**
     * 修改数据
     *
     * @param roleResourceRelation 实例对象
     * @return 实例对象
     */
    RoleResourceRelation update(RoleResourceRelation roleResourceRelation);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);
    boolean delete(Long roleId, Long resourceId);
}