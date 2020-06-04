package pers.ccy.ssatweb.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pers.ccy.ssatweb.domain.UserInfo;

import java.util.List;

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

    @Select("select id, username, nickname, role, active from user limit #{num}, #{size}")
    List<UserInfo> findAll(int num, int size);

    @Select("select count(*) from user")
    int countAll();

    @Select("select * from user_whitelist where userId = #{userId}")
    UserInfo findUserInWhiteList(int userId);

    @Update("UPDATE `user` SET active = #{status} WHERE id = #{userId}")
    void updateUserStatus(int userId, int status);
}
