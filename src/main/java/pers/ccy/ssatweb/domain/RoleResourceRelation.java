package pers.ccy.ssatweb.domain;

import java.io.Serializable;

/**
 * (RoleResourceRelation)实体类
 *
 * @author makejava
 * @since 2020-07-02 09:22:11
 */
public class RoleResourceRelation implements Serializable {
    private static final long serialVersionUID = -35040911968993578L;
    
    private Long id;
    /**
    * 角色ID
    */
    private Long roleId;
    /**
    * 资源ID
    */
    private Long resourceId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

}