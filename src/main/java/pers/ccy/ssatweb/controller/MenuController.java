package pers.ccy.ssatweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.ccy.ssatweb.common.RespBean;
import pers.ccy.ssatweb.service.MenuService;

/**
 * @author desperado
 * @ClassName MenuController
 * @Description
 * @date 2020/5/21 11:11
 * @Version 1.0
 */

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/all")
    public RespBean findAllMenu() {
        return menuService.findAllMenu();
    }
}
