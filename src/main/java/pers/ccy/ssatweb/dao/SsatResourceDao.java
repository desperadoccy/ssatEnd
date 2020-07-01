package pers.ccy.ssatweb.dao;

import pers.ccy.ssatweb.domain.SsatResource;

public interface SsatResourceDao {
    int deleteByPrimaryKey(Long id);

    int insert(SsatResource record);

    int insertSelective(SsatResource record);

    SsatResource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SsatResource record);

    int updateByPrimaryKey(SsatResource record);
}