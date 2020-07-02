package pers.ccy.ssatweb.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import pers.ccy.ssatweb.dao.AdminRoleRelationDao;
import pers.ccy.ssatweb.dao.SsatAdminDao;
import pers.ccy.ssatweb.dao.SsatRoleDao;
import pers.ccy.ssatweb.domain.*;
import pers.ccy.ssatweb.dto.SsatAdminDTO;
import pers.ccy.ssatweb.dto.UpdateAdminPasswordDTO;
import pers.ccy.ssatweb.security.utils.JwtTokenUtil;
import pers.ccy.ssatweb.service.SsatAdminService;

import java.util.ArrayList;
import java.util.Date;
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
    private SsatAdminDao ssatAdminDao;
    @Autowired
    private SsatRoleDao ssatRoleDao;
    @Autowired
    private AdminRoleRelationDao adminRoleRelationDao;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public SsatAdmin getAdminByUsername(String username) {
        SsatAdmin admin = ssatAdminDao.getAdminByUsername(username);
        return admin;
    }

    @Override
    public SsatAdmin register(SsatAdminDTO ssatAdminDTO) {
        SsatAdmin ssatAdmin = SsatAdmin.parseBy(ssatAdminDTO);
        ssatAdmin.setCreateTime(new Date());
        ssatAdmin.setStatus(1);
        try {
            ssatAdminDao.insert(ssatAdmin);
            return ssatAdmin;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if(!passwordEncoder.matches(password,userDetails.getPassword())){
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return token;
    }

    @Override
    public String refreshToken(String oldToken) {
        return jwtTokenUtil.refreshHeadToken(oldToken);
    }

    @Override
    public SsatAdmin getItem(Long id) {
        return ssatAdminDao.queryById(id);
    }

    @Override
    public List<SsatAdmin> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        if (!StringUtils.isEmpty(keyword)) {
            String query = "%" + keyword + "%";
            return ssatAdminDao.selectAdmin(query);
        }
        return null;
    }

    @Override
    public int update(Long id, SsatAdmin admin) {
        admin.setId(id);
        return ssatAdminDao.update(admin);
    }

    @Override
    public int delete(Long id) {
        return ssatAdminDao.deleteById(id);
    }

    @Override
    public int updateRole(Long adminId, List<Long> roleIds) {
        int count = roleIds == null ? 0 : roleIds.size();
        //先删除原来的关系
        adminRoleRelationDao.deleteByAdminId(adminId);
        //建立新关系
        if (!CollectionUtils.isEmpty(roleIds)) {
            for (Long roleId : roleIds) {
                AdminRoleRelation roleRelation = new AdminRoleRelation();
                roleRelation.setAdminId(adminId);
                roleRelation.setRoleId(roleId);
                adminRoleRelationDao.insert(roleRelation);
            }
        }
        return count;

    }

    @Override
    public List<SsatRole> getRoleList(Long adminId) {
        return ssatRoleDao.queryByAdminId(adminId);
    }

    @Override
    public List<SsatResource> getResourceList(Long adminId) {
        List<SsatResource> resourceList = adminRoleRelationDao.getResourceList(adminId);
        return resourceList;
    }

    @Override
    public int updatePermission(Long adminId, List<Long> permissionIds) {
//        //删除原所有权限关系
//        adminPermissionRelationMapper.deleteByAdminId(adminId);
//        //获取用户所有角色权限
//        List<UmsPermission> permissionList = adminRoleRelationDao.getRolePermissionList(adminId);
//        List<Long> rolePermissionList = permissionList.stream().map(UmsPermission::getId).collect(Collectors.toList());
//        if (!CollectionUtils.isEmpty(permissionIds)) {
//            List<UmsAdminPermissionRelation> relationList = new ArrayList<>();
//            //筛选出+权限
//            List<Long> addPermissionIdList = permissionIds.stream().filter(permissionId -> !rolePermissionList.contains(permissionId)).collect(Collectors.toList());
//            //筛选出-权限
//            List<Long> subPermissionIdList = rolePermissionList.stream().filter(permissionId -> !permissionIds.contains(permissionId)).collect(Collectors.toList());
//            //插入+-权限关系
//            relationList.addAll(convert(adminId,1,addPermissionIdList));
//            relationList.addAll(convert(adminId,-1,subPermissionIdList));
//            return adminPermissionRelationDao.insertList(relationList);
//        }
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
        //获取用户信息
        SsatAdmin admin = getAdminByUsername(username);
        if (admin != null) {
            List<SsatResource> resourceList = getResourceList(admin.getId());
            return new AdminUserDetails(admin,resourceList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }
}
