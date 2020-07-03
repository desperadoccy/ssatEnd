package pers.ccy.ssatweb.service.impl;

import pers.ccy.ssatweb.domain.SsatResource;
import pers.ccy.ssatweb.dao.SsatResourceDao;
import pers.ccy.ssatweb.service.SsatResourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SsatResource)表服务实现类
 *
 * @author makejava
 * @since 2020-07-02 09:24:13
 */
@Service("ssatResourceService")
public class SsatResourceServiceImpl implements SsatResourceService {
    @Resource
    private SsatResourceDao ssatResourceDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SsatResource queryById(Long id) {
        return this.ssatResourceDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SsatResource> queryAllByLimit(int offset, int limit) {
        return this.ssatResourceDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param ssatResource 实例对象
     * @return 实例对象
     */
    @Override
    public SsatResource insert(SsatResource ssatResource) {
        this.ssatResourceDao.insert(ssatResource);
        return ssatResource;
    }

    /**
     * 修改数据
     *
     * @param ssatResource 实例对象
     * @return 实例对象
     */
    @Override
    public SsatResource update(SsatResource ssatResource) {
        this.ssatResourceDao.update(ssatResource);
        return this.queryById(ssatResource.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.ssatResourceDao.deleteById(id) > 0;
    }

    /**
     * 查询所有数据
     *
     * @param
     * @return 查询结果
     */
    @Override
    public List<SsatResource> listAll() {
        return ssatResourceDao.queryAll(new SsatResource());
    }
}