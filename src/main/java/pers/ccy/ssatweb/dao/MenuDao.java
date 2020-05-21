package pers.ccy.ssatweb.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import pers.ccy.ssatweb.domain.Menu;

import java.util.List;

@Mapper
public interface MenuDao {

    @Select("select * from menu")
    List<Menu> findAll();
}
