package pers.ccy.ssatweb.domain;

import java.io.Serializable;

/**
 * (AdminPermissionRelation)实体类
 *
 * @author makejava
 * @since 2020-07-02 23:17:25
 */
public class AdminPermissionRelation implements Serializable {
    private static final long serialVersionUID = 916497732798589175L;
    
    private Long id;
    
    private Long adminId;
    
    private Long permissionId;
    
    private Integer type;


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

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}