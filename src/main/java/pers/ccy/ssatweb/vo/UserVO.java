package pers.ccy.ssatweb.vo;

import pers.ccy.ssatweb.domain.UserInfo;
import pers.ccy.ssatweb.utils.ExtractUtil;
import pers.ccy.ssatweb.utils.ModelMapperUtil;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

/**
 * @author desperado
 * @ClassName UserVO
 * @Description
 * @date 2020/5/22 14:32
 * @Version 1.0
 */
public class UserVO {
    private int id;
    private String username;
    private String nickname;
    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        admin, editor
    }

    private boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public static List<UserVO> parseBy(List<UserInfo> list) {
        return ExtractUtil.transferToList(list, UserVO::parseBy);
    }

    public static UserVO parseBy(UserInfo userInfo) {
        return ModelMapperUtil.map(userInfo, UserVO.class);
    }
}
