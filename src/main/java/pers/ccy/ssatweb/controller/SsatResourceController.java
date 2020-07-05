package pers.ccy.ssatweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.ccy.ssatweb.common.RespBean;
import pers.ccy.ssatweb.domain.SsatResource;
import pers.ccy.ssatweb.service.RoleResourceRelationService;
import pers.ccy.ssatweb.service.SsatResourceService;
import pers.ccy.ssatweb.vo.SsatResourceCategoryVO;

import java.util.Date;
import java.util.List;

/**
 * @author desperado
 * @ClassName SsatResourceController
 * @Description
 * @date 2020/7/4 1:44
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/resource")
public class SsatResourceController {
    @Autowired
    private SsatResourceService ssatResourceService;
    @Autowired
    private RoleResourceRelationService roleResourceRelationService;

    @GetMapping(value = "/{id}")
    public RespBean getItem(@PathVariable Long id) {
        try {
            SsatResource resource = ssatResourceService.queryById(id);
            return RespBean.ok("查询成功", resource);
        } catch (Exception e) {
            return RespBean.error("查询失败");
        }
    }

    @GetMapping(value = "/listCategory")
    public RespBean listCategory() {
        try {
            List<SsatResourceCategoryVO> category = ssatResourceService.listAllWithCategory();
            return RespBean.ok("查询成功", category);
        } catch (Exception e) {
            return RespBean.error("查询失败");
        }
    }

    @GetMapping(value = "/list")
    public RespBean list() {
        try {
            List<SsatResource> resources = ssatResourceService.listAll();
            return RespBean.ok("查询成功", resources);
        } catch (Exception e) {
            return RespBean.error("查询失败");
        }
    }

    @GetMapping(value = "/deleteResource")
    public RespBean deleteResource(Long roleId, Long resourceId) {
        try {
            if (roleId == 1)
                return RespBean.error("超级管理员无法修改权限");
            roleResourceRelationService.delete(roleId, resourceId);
            return RespBean.ok("删除成功");
        } catch (Exception e) {
            return RespBean.error("删除失败");
        }
    }

    @PostMapping("/add")
    public RespBean add(SsatResource resource) {
        try {
            resource.setCreateTime(new Date());
            ssatResourceService.insert(resource);
            return RespBean.ok("添加成功");
        } catch (Exception e){
            return RespBean.error("添加失败");
        }
    }
}
