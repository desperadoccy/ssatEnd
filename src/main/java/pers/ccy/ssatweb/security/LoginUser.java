package pers.ccy.ssatweb.security;

import java.io.Serializable;

/**
 * @author desperado
 * @ClassName LoginUser
 * @Description
 * @date 2020/6/3 10:53
 * @Version 1.0
 */
public class LoginUser implements Serializable {
    private String username;
    private String role;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", id=" + id +
                '}';
    }
}
