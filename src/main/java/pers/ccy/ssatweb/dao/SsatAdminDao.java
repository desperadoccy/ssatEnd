package pers.ccy.ssatweb.dao;

import pers.ccy.ssatweb.domain.SsatAdmin;

public interface SsatAdminDao {
    int deleteByPrimaryKey(Long id);

    int insert(SsatAdmin record);

    int insertSelective(SsatAdmin record);

    SsatAdmin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SsatAdmin record);

    int updateByPrimaryKey(SsatAdmin record);

    SsatAdmin getAdminByUsername(String username);
}