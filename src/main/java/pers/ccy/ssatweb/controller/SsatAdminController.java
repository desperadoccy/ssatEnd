package pers.ccy.ssatweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import pers.ccy.ssatweb.common.RespBean;
import pers.ccy.ssatweb.domain.SsatAdmin;
import pers.ccy.ssatweb.dto.SsatAdminDTO;
import pers.ccy.ssatweb.service.AdminRoleRelationService;
import pers.ccy.ssatweb.service.SsatAdminService;
import pers.ccy.ssatweb.service.SsatRoleService;
import pers.ccy.ssatweb.vo.SsatAdminVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author desperado
 * @ClassName SsatAdminController
 * @Description
 * @date 2020/7/2 22:41
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/admin")
public class SsatAdminController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private SsatAdminService adminService;
    @Autowired
    private AdminRoleRelationService adminRoleRelationService;
    @Autowired
    private SsatRoleService roleService;

    @PostMapping(value = "/register")
    public RespBean register(SsatAdminDTO ssatAdminDTO) {
        try {
            SsatAdmin register = adminService.register(ssatAdminDTO);
            return RespBean.ok("注册成功", register);
        } catch (Exception e) {
            return RespBean.error(e.getMessage());
        }
    }

    @PostMapping(value = "/login")
    public RespBean login(String username, String password) {
        try {
            String token = adminService.login(username, password);
            if (token == null)
                return RespBean.error("账号或用户名错误");
            else {
                String tokenMap = tokenHead + " " + token;
                return RespBean.ok("登录成功", tokenMap);
            }
        } catch (Exception e) {
            return RespBean.error("登录失败");
        }
    }

    @GetMapping("/find")
    public RespBean findUser(Integer pageNum, Integer pageSize, String query) {
        try {
            String queryLike = null;
            if (query != null && query != "")
                queryLike = "%" + query + "%";
            List<SsatAdminVO> list = adminService.list(queryLike, pageSize, pageNum);
            int count = adminService.count();
            Map<String,Object> map = new HashMap<>();
            map.put("count",count);
            map.put("users",list);
            return RespBean.ok("查询成功", map);
        } catch (Exception e) {
            return RespBean.error("查询失败");
        }
    }

    @PostMapping("/update/status")
    public RespBean updateStatus(Long userId, int status) {
        try {
            adminService.updateStatus(userId, status);
            return RespBean.ok("更新成功");
        } catch (Exception e) {
            return RespBean.error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public RespBean findUserById(@PathVariable("id") Long id) {
        try {
            SsatAdminVO admin = adminService.getAdminById(id);
            return RespBean.ok("查询成功", admin);
        } catch (Exception e) {
            return RespBean.error(e.getMessage());
        }
    }

    @PostMapping("/update")
    public RespBean updateUser(SsatAdminDTO ssatAdminDTO) {
        try {
            SsatAdmin admin = SsatAdminDTO.parseBy(ssatAdminDTO);
            adminService.update(admin.getId(), admin);
            return RespBean.ok("更新成功");
        } catch (Exception e) {
            return RespBean.error(e.getMessage());
        }
    }

    @GetMapping("/delete/{id}")
    public RespBean deleteUserById(@PathVariable("id") Long id) {
        try {
            adminService.delete(id);
            return RespBean.ok("删除成功");
        } catch (Exception e) {
            return RespBean.error(e.getMessage());
        }
    }


    @GetMapping(value = "/updateRole")
    public RespBean updateRole(Long userId,Long roleId){
        try {
            adminRoleRelationService.updateRole(userId, roleId);
            return RespBean.ok("更新成功");
        }catch (Exception e){
            return RespBean.error("更新失败");
        }
    }
}
