package pers.ccy.ssatweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.ccy.ssatweb.common.RespBean;
import pers.ccy.ssatweb.domain.SsatResourceCategory;
import pers.ccy.ssatweb.service.SsatResourceCategoryService;

import java.util.List;

/**
 * @author desperado
 * @ClassName SsatResourceCategoryController
 * @Description
 * @date 2020/7/6 2:37
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/resourceCategory")
public class SsatResourceCategoryController {
    @Autowired
    private SsatResourceCategoryService ssatResourceCategoryService;

    @GetMapping("/list")
    public RespBean list() {
        try {
            List<SsatResourceCategory> categoryList = ssatResourceCategoryService.queryAllByLimit(0, 10);
            return RespBean.ok("查询成功", categoryList);
        }catch (Exception e){
            return RespBean.error("查询失败");
        }
    }
}
