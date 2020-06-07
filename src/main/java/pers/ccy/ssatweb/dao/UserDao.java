package pers.ccy.ssatweb.dao;

import org.apache.ibatis.annotations.*;
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

    @Select("<script>" +
            "select " +
            "id, username, nickname, role, active " +
            "from user " +
            "<if test = 'query != null'> " +
            "where username like #{query} " +
            "</if> " +
            "limit #{num}, #{size} " +
            "</script>")
    List<UserInfo> findUser(int num, int size, String query);

    @Select("<script>" +
            "select count(*) from user" +
            "<if test = 'query != null'> " +
            "where username like #{query} " +
            "</if> " +
            "</script>")
    int countAll(String query);

    @Select("select * from user_whitelist where userId = #{userId}")
    UserInfo findUserInWhiteList(int userId);

    @Update("UPDATE `user` SET active = #{status} WHERE id = #{userId}")
    void updateUserStatus(int userId, int status);

    @Select("select * from user where id = #{id}")
    UserInfo findUserById(int id);

    @Update("UPDATE `user` SET nickname = #{nickname} WHERE id = #{id}")
    void updateUser(UserInfo userInfo);

    @Delete("delete from user where id = #{id}")
    void deleteUser(int id);
}
