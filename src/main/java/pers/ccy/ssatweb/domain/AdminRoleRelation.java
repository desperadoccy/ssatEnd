package pers.ccy.ssatweb.domain;

import java.io.Serializable;

/**
 * (AdminRoleRelation)实体类
 *
 * @author makejava
 * @since 2020-07-02 09:22:36
 */
public class AdminRoleRelation implements Serializable {
    private static final long serialVersionUID = -24711798052173671L;
    
    private Long id;
    
    private Long adminId;
    
    private Long roleId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

}