package pers.ccy.ssatweb.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import pers.ccy.ssatweb.domain.Right;

import java.util.List;

/**
 * @author desperado
 * @ClassName RightDao
 * @Description
 * @date 2020/6/7 16:13
 * @Version 1.0
 */
@Mapper
public interface RightDao {
    @Select("select * from rights")
    List<Right> list();

    @Select("select rights.* from user u " +
            "left join role_user rs on u.id = rs.userId " +
            "left join role r on rs.roleId = r.id " +
            "left join right_role rr on rr.roleId = r.id " +
            "left join rights on rights.id = rr.rightId where u.id = 1;")
    List<Right> findByAdminUserId(int userId);
}
