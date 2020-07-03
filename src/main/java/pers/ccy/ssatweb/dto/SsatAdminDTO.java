package pers.ccy.ssatweb.dto;


import pers.ccy.ssatweb.domain.SsatAdmin;
import pers.ccy.ssatweb.utils.ModelMapperUtil;

/**
 * @author desperado
 * @ClassName SsatAdminDTO
 * @Description
 * @date 2020/7/2 0:53
 * @Version 1.0
 */
public class SsatAdminDTO {
    /**
     * 用户id
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 头像
     */
    private String icon;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 备注信息
     */
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public static SsatAdmin parseBy(SsatAdminDTO ssatAdminDTO) {
        return ModelMapperUtil.map(ssatAdminDTO, SsatAdmin.class);
    }
}
