package pers.ccy.ssatweb.vo;

import pers.ccy.ssatweb.domain.SsatAdmin;
import pers.ccy.ssatweb.domain.SsatRole;
import pers.ccy.ssatweb.utils.ExtractUtil;
import pers.ccy.ssatweb.utils.ModelMapperUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author desperado
 * @ClassName SsatAdminVO
 * @Description
 * @date 2020/7/4 0:50
 * @Version 1.0
 */
public class SsatAdminVO {
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
    private Integer status;
    /**
     * 身份
     */
    private String role;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static List<SsatAdminVO> parseBy(List<SsatAdmin> list, List<String> roles) {
        List<SsatAdminVO> ssatAdminVOS = new ArrayList<>();
        for (int i = 0; i < list.size(); i++)
            ssatAdminVOS.add(parseBy(list.get(i), roles.get(i)));
        return ssatAdminVOS;
    }

    public static SsatAdminVO parseBy(SsatAdmin admin, String role) {
        SsatAdminVO adminVO = ModelMapperUtil.map(admin, SsatAdminVO.class);
        adminVO.setRole(role);
        return adminVO;
    }
}
