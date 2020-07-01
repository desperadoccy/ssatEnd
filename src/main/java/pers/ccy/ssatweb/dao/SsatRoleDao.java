package pers.ccy.ssatweb.dao;

import pers.ccy.ssatweb.domain.SsatRole;

public interface SsatRoleDao {
    int deleteByPrimaryKey(Long id);

    int insert(SsatRole record);

    int insertSelective(SsatRole record);

    SsatRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SsatRole record);

    int updateByPrimaryKey(SsatRole record);
}