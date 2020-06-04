package pers.ccy.ssatweb.vo;

import java.util.List;

/**
 * @author desperado
 * @ClassName UsersVO
 * @Description
 * @date 2020/5/22 14:38
 * @Version 1.0
 */
public class UsersVO {
    List<UserVO> users;
    int count;

    public List<UserVO> getUsers() {
        return users;
    }

    public void setUsers(List<UserVO> users) {
        this.users = users;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
