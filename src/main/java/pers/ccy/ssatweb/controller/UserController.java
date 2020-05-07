package pers.ccy.ssatweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.ccy.ssatweb.common.RespBean;
import pers.ccy.ssatweb.domain.UserInfo;
import pers.ccy.ssatweb.service.UserService;

/**
 * @author desperado
 * @ClassName UserController
 * @Description
 * @date 2020/5/2 21:45
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/helloAdmin")
    @PreAuthorize("hasAnyRole('admin')")
    public String helloAdmin() {
        return "hello,admin";
    }

    @GetMapping("/helloEditor")
    @PreAuthorize("hasAnyRole('editor')")
    public String helloEditor() {
        return "hello,editor";
    }

    @PostMapping("/addUser")
    public RespBean addUser(UserInfo userInfo) {
        return userService.addUser(userInfo);
    }
}
