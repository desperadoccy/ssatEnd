package pers.ccy.ssatweb.domain;

import java.io.Serializable;

/**
 * (RoleMenuRelation)实体类
 *
 * @author makejava
 * @since 2020-07-02 09:22:18
 */
public class RoleMenuRelation implements Serializable {
    private static final long serialVersionUID = 750640772813767882L;
    
    private Long id;
    /**
    * 角色ID
    */
    private Long roleId;
    /**
    * 菜单ID
    */
    private Long menuId;


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

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

}