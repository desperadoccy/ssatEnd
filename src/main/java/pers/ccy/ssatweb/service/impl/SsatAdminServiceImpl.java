package pers.ccy.ssatweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import pers.ccy.ssatweb.dao.SsatAdminDao;
import pers.ccy.ssatweb.domain.SsatAdmin;
import pers.ccy.ssatweb.domain.SsatPermission;
import pers.ccy.ssatweb.domain.SsatResource;
import pers.ccy.ssatweb.domain.SsatRole;
import pers.ccy.ssatweb.dto.SsatAdminDTO;
import pers.ccy.ssatweb.dto.UpdateAdminPasswordDTO;
import pers.ccy.ssatweb.service.SsatAdminService;

import java.util.List;

/**
 * @author desperado
 * @ClassName SsatAdminServiceImpl
 * @Description
 * @date 2020/7/2 0:58
 * @Version 1.0
 */
public class SsatAdminServiceImpl implements SsatAdminService {
    @Autowired
    SsatAdminDao SsatAdminDao;

    @Override
    public SsatAdmin getAdminByUsername(String username) {
        SsatAdmin admin = SsatAdminDao.getAdminByUsername(username);
        return admin;
    }

    @Override
    public SsatAdmin register(SsatAdminDTO SsatAdminDTO) {
        SsatAdmin admin = new SsatAdmin();

        return null;
    }

    @Override
    public String login(String username, String password) {
        return null;
    }

    @Override
    public String refreshToken(String oldToken) {
        return null;
    }

    @Override
    public SsatAdmin getItem(Long id) {
        return null;
    }

    @Override
    public List<SsatAdmin> list(String keyword, Integer pageSize, Integer pageNum) {
        return null;
    }

    @Override
    public int update(Long id, SsatAdmin admin) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public int updateRole(Long adminId, List<Long> roleIds) {
        return 0;
    }

    @Override
    public List<SsatRole> getRoleList(Long adminId) {
        return null;
    }

    @Override
    public List<SsatResource> getResourceList(Long adminId) {
        return null;
    }

    @Override
    public int updatePermission(Long adminId, List<Long> permissionIds) {
        return 0;
    }

    @Override
    public List<SsatPermission> getPermissionList(Long adminId) {
        return null;
    }

    @Override
    public int updatePassword(UpdateAdminPasswordDTO updateAdminPasswordDTO) {
        return 0;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return null;
    }
}
