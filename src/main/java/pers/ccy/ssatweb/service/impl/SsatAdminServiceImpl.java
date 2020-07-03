package pers.ccy.ssatweb.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import pers.ccy.ssatweb.dao.*;
import pers.ccy.ssatweb.domain.*;
import pers.ccy.ssatweb.dto.SsatAdminDTO;
import pers.ccy.ssatweb.dto.UpdateAdminPasswordDTO;
import pers.ccy.ssatweb.security.utils.JwtTokenUtil;
import pers.ccy.ssatweb.service.SsatAdminService;
import pers.ccy.ssatweb.utils.ServletUtil;
import pers.ccy.ssatweb.vo.SsatAdminVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author desperado
 * @ClassName SsatAdminServiceImpl
 * @Description
 * @date 2020/7/2 0:58
 * @Version 1.0
 */
@Service
public class SsatAdminServiceImpl implements SsatAdminService {
    @Autowired
    private SsatAdminDao ssatAdminDao;
    @Autowired
    private SsatRoleDao ssatRoleDao;
    @Autowired
    private AdminRoleRelationDao adminRoleRelationDao;
    @Autowired
    private AdminPermissionRelationDao adminPermissionRelationDao;
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
        ssatAdmin.setPassword(passwordEncoder.encode(ssatAdmin.getPassword()));
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
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
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
    public List<SsatAdminVO> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        String query = null;
        if (keyword != null)
            query = "%" + keyword + "%";
        List<SsatAdmin> adminList = ssatAdminDao.selectAdmin(query);
        List<String> roleList = new ArrayList<>();
        for (SsatAdmin admin : adminList) {
            String name = ssatRoleDao.queryByAdminId(admin.getId()).get(0).getName();
            roleList.add(name);
        }
        return SsatAdminVO.parseBy(adminList, roleList);
    }

    @Override
    public int update(Long id, SsatAdmin admin) {
        admin.setId(id);
        return ssatAdminDao.update(admin);
    }

    @Override
    public int delete(Long id) throws Exception {
        String name = jwtTokenUtil.getUserNameFromToken(ServletUtil.getRequest().getHeader("Authorization"));
        SsatAdmin admin = ssatAdminDao.getAdminByUsername(name);
        if (admin.getId() == id)
            throw new Exception("不能删除自己");
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
        //删除原所有权限关系
        adminPermissionRelationDao.deleteByAdminId(adminId);
        //获取用户所有角色权限
        List<SsatPermission> permissionList = adminRoleRelationDao.getRolePermissionList(adminId);
        List<Long> rolePermissionList = permissionList.stream().map(SsatPermission::getId).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(permissionIds)) {
            List<AdminPermissionRelation> relationList = new ArrayList<>();
            //筛选出+权限
            List<Long> addPermissionIdList = permissionIds.stream().filter(permissionId -> !rolePermissionList.contains(permissionId)).collect(Collectors.toList());
            //筛选出-权限
            List<Long> subPermissionIdList = rolePermissionList.stream().filter(permissionId -> !permissionIds.contains(permissionId)).collect(Collectors.toList());
            //插入+-权限关系
            relationList.addAll(convert(adminId, 1, addPermissionIdList));
            relationList.addAll(convert(adminId, -1, subPermissionIdList));
            for (AdminPermissionRelation relation : relationList)
                adminPermissionRelationDao.insert(relation);
            return 1;
        }
        return 0;
    }

    /**
     * 将+-权限关系转化为对象
     */
    private List<AdminPermissionRelation> convert(Long adminId, Integer type, List<Long> permissionIdList) {
        List<AdminPermissionRelation> relationList = permissionIdList.stream().map(permissionId -> {
            AdminPermissionRelation relation = new AdminPermissionRelation();
            relation.setAdminId(adminId);
            relation.setType(type);
            relation.setPermissionId(permissionId);
            return relation;
        }).collect(Collectors.toList());
        return relationList;
    }

    @Override
    public List<SsatPermission> getPermissionList(Long adminId) {
        return adminRoleRelationDao.getPermissionList(adminId);
    }

    @Override
    public int updatePassword(UpdateAdminPasswordDTO dto) {
        if (StrUtil.isEmpty(dto.getUsername())
                || StrUtil.isEmpty(dto.getOldPassword())
                || StrUtil.isEmpty(dto.getNewPassword())) {
            return -1;
        }
        List<SsatAdmin> adminList = ssatAdminDao.selectAdmin(dto.getUsername());
        if (CollUtil.isEmpty(adminList)) {
            return -2;
        }
        SsatAdmin admin = adminList.get(0);
        if (!passwordEncoder.matches(dto.getOldPassword(), admin.getPassword())) {
            return -3;
        }
        admin.setPassword(passwordEncoder.encode(dto.getNewPassword()));
        ssatAdminDao.update(admin);
        return 1;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        //获取用户信息
        SsatAdmin admin = getAdminByUsername(username);
        if (admin != null) {
            List<SsatResource> resourceList = getResourceList(admin.getId());
            return new AdminUserDetails(admin, resourceList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    @Override
    public void updateStatus(Long userId, int status) throws Exception {
        String name = jwtTokenUtil.getUserNameFromToken(ServletUtil.getRequest().getHeader("Authorization"));
        SsatAdmin admin = ssatAdminDao.getAdminByUsername(name);
        if (admin.getId() == userId)
            throw new Exception("不能修改自己的状态");
        List<SsatRole> roles = ssatRoleDao.queryByAdminId(userId);
        ssatAdminDao.updateStatus(userId, status);
    }

    @Override
    public SsatAdminVO getAdminById(Long userId) {
        SsatAdmin ssatAdmin = ssatAdminDao.queryById(userId);
        List<SsatRole> roles = ssatRoleDao.queryByAdminId(userId);
        SsatAdminVO ssatAdminVO = SsatAdminVO.parseBy(ssatAdmin, roles.get(0).getName());
        return ssatAdminVO;
    }
}
