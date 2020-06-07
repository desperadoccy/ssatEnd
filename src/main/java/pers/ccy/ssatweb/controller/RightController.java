package pers.ccy.ssatweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.ccy.ssatweb.common.RespBean;
import pers.ccy.ssatweb.service.RightService;

/**
 * @author desperado
 * @ClassName RightController
 * @Description
 * @date 2020/6/7 16:13
 * @Version 1.0
 */
@RestController
@RequestMapping("/rights")
public class RightController {
    @Autowired
    RightService rightService;

    @GetMapping("/list")
    public RespBean list(){
        return rightService.list();
    }
}
