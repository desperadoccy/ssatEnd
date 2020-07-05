package pers.ccy.ssatweb.service;

import pers.ccy.ssatweb.domain.SsatResource;
import pers.ccy.ssatweb.domain.SsatResourceCategory;
import pers.ccy.ssatweb.vo.SsatResourceCategoryVO;
import pers.ccy.ssatweb.vo.SsatResourceVO;

import java.util.List;
import java.util.Map;

/**
 * (SsatResource)表服务接口
 *
 * @author makejava
 * @since 2020-07-02 09:24:13
 */
public interface SsatResourceService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SsatResource queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SsatResource> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param ssatResource 实例对象
     * @return 实例对象
     */
    SsatResource insert(SsatResource ssatResource);

    /**
     * 修改数据
     *
     * @param ssatResource 实例对象
     * @return 实例对象
     */
    SsatResource update(SsatResource ssatResource);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 查询所有数据
     *
     * @param
     * @return 查询结果
     */
    List<SsatResource> listAll();
    List<SsatResourceCategoryVO> listAllWithCategory();
}