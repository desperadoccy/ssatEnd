package pers.ccy.ssatweb.domain;

/**
 * @author desperado
 * @ClassName RolePermissionRelation
 * @Description
 * @date 2020/7/2 22:06
 * @Version 1.0
 */
public class RolePermissionRelation {
    private Long id;

    private Long roleId;

    private Long permissionId;

    private static final long serialVersionUID = 1L;

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

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}
