package pers.ccy.ssatweb.dao;

import pers.ccy.ssatweb.domain.SsatResourceCategory;

public interface SsatResourceCategoryDao {
    int deleteByPrimaryKey(Long id);

    int insert(SsatResourceCategory record);

    int insertSelective(SsatResourceCategory record);

    SsatResourceCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SsatResourceCategory record);

    int updateByPrimaryKey(SsatResourceCategory record);
}