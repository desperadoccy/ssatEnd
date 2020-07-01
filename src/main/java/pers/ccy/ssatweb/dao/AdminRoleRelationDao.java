package pers.ccy.ssatweb.dao;

import pers.ccy.ssatweb.domain.AdminRoleRelation;

public interface AdminRoleRelationDao {
    int deleteByPrimaryKey(Long id);

    int insert(AdminRoleRelation record);

    int insertSelective(AdminRoleRelation record);

    AdminRoleRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdminRoleRelation record);

    int updateByPrimaryKey(AdminRoleRelation record);
}