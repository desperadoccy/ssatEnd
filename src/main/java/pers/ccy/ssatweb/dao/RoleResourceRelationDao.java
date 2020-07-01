package pers.ccy.ssatweb.dao;

import pers.ccy.ssatweb.domain.RoleResourceRelation;

public interface RoleResourceRelationDao {
    int deleteByPrimaryKey(Long id);

    int insert(RoleResourceRelation record);

    int insertSelective(RoleResourceRelation record);

    RoleResourceRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleResourceRelation record);

    int updateByPrimaryKey(RoleResourceRelation record);
}