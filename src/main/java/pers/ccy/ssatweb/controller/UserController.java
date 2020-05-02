package pers.ccy.ssatweb.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/helloAdmin")
    @PreAuthorize("hasAnyRole('admin')")
    public String helloAdmin() {
        return "hello,admin";
    }

    @GetMapping("/helloEditor")
    @PreAuthorize("hasAnyRole('editor', 'admin')")
    public String helloEditor() {
        return "hello,editor";
    }
}
