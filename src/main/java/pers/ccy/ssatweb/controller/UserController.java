package pers.ccy.ssatweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/add")
    public RespBean addUser(UserInfo userInfo) {
        return userService.addUser(userInfo);
    }

    @GetMapping("/find")
    public RespBean findUser(int pageNum, int pageSize, String query) {
        String queryLike = null;
        if (query != null)
            queryLike = "%" + query + "%";
        return userService.findUser(pageNum, pageSize, queryLike);
    }

    @PostMapping("/update/status")
    public RespBean updateStatus(int userId, int status) {
        return userService.updateStatus(userId, status);
    }

    @GetMapping("/{id}")
    public RespBean findUserById(@PathVariable("id") int id) {
        return userService.findUserById(id);
    }

    @PostMapping("/update")
    public RespBean updateUser(UserInfo userInfo) {
        return userService.updateUser(userInfo);
    }

    @GetMapping("/delete/{id}")
    public RespBean deleteUserById(@PathVariable("id") int id) {
        return userService.deleteUser(id);
    }
}
