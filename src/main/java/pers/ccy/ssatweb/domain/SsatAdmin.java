package pers.ccy.ssatweb.domain;

import pers.ccy.ssatweb.dto.SsatAdminDTO;
import pers.ccy.ssatweb.utils.ExtractUtil;
import pers.ccy.ssatweb.utils.ModelMapperUtil;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (SsatAdmin)实体类
 *
 * @author makejava
 * @since 2020-07-02 09:23:17
 */
public class SsatAdmin implements Serializable {
    private static final long serialVersionUID = -57469029351264886L;
    
    private Long id;
    /**
    * 用户名
    */
    private String username;
    /**
    * 密码
    */
    private String password;
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
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 最后登录时间
    */
    private Date loginTime;
    /**
    * 帐号启用状态：0->禁用；1->启用
    */
    private Integer active;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public static List<SsatAdmin> parseBy(List<SsatAdminDTO> list) {
        return ExtractUtil.transferToList(list, SsatAdmin::parseBy);
    }

    public static SsatAdmin parseBy(SsatAdminDTO ssatAdminDTO) {
        return ModelMapperUtil.map(ssatAdminDTO, SsatAdmin.class);
    }
}