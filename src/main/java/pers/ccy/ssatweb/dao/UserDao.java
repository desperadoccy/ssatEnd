package pers.ccy.ssatweb.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import pers.ccy.ssatweb.domain.UserInfo;

/**
 * @author desperado
 * @ClassName UserDao
 * @Description
 * @date 2020/5/2 21:40
 * @Version 1.0
 */
@Mapper
public interface UserDao {
    @Select("select * from user where username = #{name}")
    UserInfo findUserByUsername(String name);

    @Insert("insert into user (username, nickname, password, role, active) values (#{username}, #{nickname}, #{password}, #{role}, 1)")
    void addUser(UserInfo userInfo);
}
