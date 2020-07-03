package pers.ccy.ssatweb.service;

import pers.ccy.ssatweb.domain.SsatPermission;
import pers.ccy.ssatweb.domain.SsatResource;
import pers.ccy.ssatweb.domain.SsatRole;
import java.util.List;

/**
 * (SsatRole)表服务接口
 *
 * @author makejava
 * @since 2020-07-02 09:24:28
 */
public interface SsatRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SsatRole queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SsatRole> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param ssatRole 实例对象
     * @return 实例对象
     */
    SsatRole insert(SsatRole ssatRole);

    /**
     * 修改数据
     *
     * @param ssatRole 实例对象
     * @return 实例对象
     */
    SsatRole update(SsatRole ssatRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);
    List<SsatPermission> getPermissionList(Long roleId);
    int updatePermission(Long roleId, List<Long> permissionIds);
    List<SsatRole> list();
    List<SsatRole> list(String keyword, Integer pageSize, Integer pageNum);
    List<SsatResource> listResource(Long roleId);
    int allocResource(Long roleId, List<Long> resourceIds);
}