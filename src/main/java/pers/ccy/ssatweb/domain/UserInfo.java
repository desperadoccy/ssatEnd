package pers.ccy.ssatweb.domain;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

/**
 * @author desperado
 * @ClassName UserInfo
 * @Description
 * @date 2020/5/2 21:34
 * @Version 1.0
 */
public class UserInfo implements Serializable {
    private int id;
    private String username;
    private String nickname;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    public enum Role{
        admin,editor
    }
    private boolean active;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", active=" + active +
                '}';
    }
}
