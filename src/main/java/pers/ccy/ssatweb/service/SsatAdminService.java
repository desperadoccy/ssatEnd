package pers.ccy.ssatweb.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import pers.ccy.ssatweb.domain.SsatAdmin;
import pers.ccy.ssatweb.domain.SsatPermission;
import pers.ccy.ssatweb.domain.SsatResource;
import pers.ccy.ssatweb.domain.SsatRole;
import pers.ccy.ssatweb.dto.SsatAdminDTO;
import pers.ccy.ssatweb.dto.UpdateAdminPasswordDTO;
import pers.ccy.ssatweb.vo.SsatAdminVO;

import java.util.List;

/**
 * @author desperado
 * @ClassName SsatAdminService
 * @Description
 * @date 2020/7/2 0:52
 * @Version 1.0
 */
public interface SsatAdminService {
    /**
     * 根据用户名获取后台管理员
     */
    SsatAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     */
    SsatAdmin register(SsatAdminDTO SsatAdminDTO) throws Exception;

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username,String password);

    /**
     * 刷新token的功能
     * @param oldToken 旧的token
     */
    String refreshToken(String oldToken);

    /**
     * 根据用户id获取用户
     */
    SsatAdmin getItem(Long id);

    /**
     * 根据用户名或昵称分页查询用户
     */
    List<SsatAdminVO> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 修改指定用户信息
     */
    int update(Long id, SsatAdmin admin);

    /**
     * 删除指定用户
     */
    int delete(Long id) throws Exception;

    /**
     * 修改用户角色关系
     */
    @Transactional
    int updateRole(Long adminId, List<Long> roleIds);

    /**
     * 获取用户对于角色
     */
    List<SsatRole> getRoleList(Long adminId);

    /**
     * 获取指定用户的可访问资源
     */
    List<SsatResource> getResourceList(Long adminId);

    /**
     * 修改用户的+-权限
     */
    @Transactional
    int updatePermission(Long adminId, List<Long> permissionIds);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    List<SsatPermission> getPermissionList(Long adminId);

    /**
     * 修改密码
     */
    int updatePassword(UpdateAdminPasswordDTO updateAdminPasswordDTO);

    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);

    void updateStatus(Long userId, int status) throws Exception;

    SsatAdminVO getAdminById(Long userId);

    int count();
}
