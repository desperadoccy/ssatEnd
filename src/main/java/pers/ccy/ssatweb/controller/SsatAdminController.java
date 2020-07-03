package pers.ccy.ssatweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pers.ccy.ssatweb.common.RespBean;
import pers.ccy.ssatweb.domain.SsatAdmin;
import pers.ccy.ssatweb.dto.SsatAdminDTO;
import pers.ccy.ssatweb.service.SsatAdminService;
import pers.ccy.ssatweb.service.SsatRoleService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author desperado
 * @ClassName SsatAdminController
 * @Description
 * @date 2020/7/2 22:41
 * @Version 1.0
 */
@RestController
@RequestMapping("/admin")
public class SsatAdminController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private SsatAdminService adminService;
    @Autowired
    private SsatRoleService roleService;

    @PostMapping(value = "/register")
    public RespBean register(SsatAdminDTO ssatAdminDTO) {
        try {
            SsatAdmin register = adminService.register(ssatAdminDTO);
            return RespBean.ok("注册成功");
        } catch (Exception e) {
            return RespBean.error("注册失败");
        }
    }

    @PostMapping(value = "/login")
    public RespBean login(String username, String password) {
        try {
            String token = adminService.login(username, password);
            if (token == null)
                return RespBean.error("账号或用户名错误");
            else {
                Map<String, String> tokenMap = new HashMap<>();
                tokenMap.put("token", token);
                tokenMap.put("tokenHead", tokenHead);
                return RespBean.ok("登录成功", tokenMap);
            }
        } catch (Exception e) {
            return RespBean.error("登录失败");
        }
    }
}
