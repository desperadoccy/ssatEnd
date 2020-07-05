package pers.ccy.ssatweb.service;

import pers.ccy.ssatweb.domain.SsatPermission;
import pers.ccy.ssatweb.domain.SsatPermissionNode;

import java.util.List;

/**
 * (SsatPermission)表服务接口
 *
 * @author makejava
 * @since 2020-07-03 15:10:22
 */
public interface SsatPermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SsatPermission queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SsatPermission> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param ssatPermission 实例对象
     * @return 实例对象
     */
    SsatPermission insert(SsatPermission ssatPermission);

    /**
     * 修改数据
     *
     * @param ssatPermission 实例对象
     * @return 实例对象
     */
    SsatPermission update(SsatPermission ssatPermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 树形权限列表
     *
     * @param
     * @return
     */
    List<SsatPermissionNode> treeList();
}