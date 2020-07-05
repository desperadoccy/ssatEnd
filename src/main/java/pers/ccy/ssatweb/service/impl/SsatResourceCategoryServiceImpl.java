package pers.ccy.ssatweb.service.impl;

import org.springframework.transaction.annotation.Transactional;
import pers.ccy.ssatweb.domain.SsatResourceCategory;
import pers.ccy.ssatweb.dao.SsatResourceCategoryDao;
import pers.ccy.ssatweb.service.SsatResourceCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SsatResourceCategory)表服务实现类
 *
 * @author makejava
 * @since 2020-07-02 09:24:28
 */
@Transactional
@Service("ssatResourceCategoryService")
public class SsatResourceCategoryServiceImpl implements SsatResourceCategoryService {
    @Resource
    private SsatResourceCategoryDao ssatResourceCategoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SsatResourceCategory queryById(Long id) {
        return this.ssatResourceCategoryDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SsatResourceCategory> queryAllByLimit(int offset, int limit) {
        return this.ssatResourceCategoryDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param ssatResourceCategory 实例对象
     * @return 实例对象
     */
    @Override
    public SsatResourceCategory insert(SsatResourceCategory ssatResourceCategory) {
        this.ssatResourceCategoryDao.insert(ssatResourceCategory);
        return ssatResourceCategory;
    }

    /**
     * 修改数据
     *
     * @param ssatResourceCategory 实例对象
     * @return 实例对象
     */
    @Override
    public SsatResourceCategory update(SsatResourceCategory ssatResourceCategory) {
        this.ssatResourceCategoryDao.update(ssatResourceCategory);
        return this.queryById(ssatResourceCategory.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.ssatResourceCategoryDao.deleteById(id) > 0;
    }
}