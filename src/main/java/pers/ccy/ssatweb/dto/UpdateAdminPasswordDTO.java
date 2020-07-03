package pers.ccy.ssatweb.dto;

/**
 * @author desperado
 * @ClassName UpdateAdminPasswordDTO
 * @Description
 * @date 2020/7/2 0:57
 * @Version 1.0
 */
public class UpdateAdminPasswordDTO {
    private String username;
    private String oldPassword;
    private String newPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
