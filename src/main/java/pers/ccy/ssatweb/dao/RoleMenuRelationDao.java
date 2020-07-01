package pers.ccy.ssatweb.dao;

import pers.ccy.ssatweb.domain.RoleMenuRelation;

public interface RoleMenuRelationDao {
    int deleteByPrimaryKey(Long id);

    int insert(RoleMenuRelation record);

    int insertSelective(RoleMenuRelation record);

    RoleMenuRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleMenuRelation record);

    int updateByPrimaryKey(RoleMenuRelation record);
}