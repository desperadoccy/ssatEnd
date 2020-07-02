package pers.ccy.ssatweb.service.impl;

import pers.ccy.ssatweb.domain.SsatRole;
import pers.ccy.ssatweb.dao.SsatRoleDao;
import pers.ccy.ssatweb.service.SsatRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SsatRole)表服务实现类
 *
 * @author makejava
 * @since 2020-07-02 09:24:28
 */
@Service("ssatRoleService")
public class SsatRoleServiceImpl implements SsatRoleService {
    @Resource
    private SsatRoleDao ssatRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SsatRole queryById(Long id) {
        return this.ssatRoleDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SsatRole> queryAllByLimit(int offset, int limit) {
        return this.ssatRoleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param ssatRole 实例对象
     * @return 实例对象
     */
    @Override
    public SsatRole insert(SsatRole ssatRole) {
        this.ssatRoleDao.insert(ssatRole);
        return ssatRole;
    }

    /**
     * 修改数据
     *
     * @param ssatRole 实例对象
     * @return 实例对象
     */
    @Override
    public SsatRole update(SsatRole ssatRole) {
        this.ssatRoleDao.update(ssatRole);
        return this.queryById(ssatRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.ssatRoleDao.deleteById(id) > 0;
    }
}