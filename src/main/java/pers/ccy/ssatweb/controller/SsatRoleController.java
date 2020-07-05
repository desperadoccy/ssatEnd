package pers.ccy.ssatweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import pers.ccy.ssatweb.common.RespBean;
import pers.ccy.ssatweb.domain.AdminRoleRelation;
import pers.ccy.ssatweb.domain.RoleResourceRelation;
import pers.ccy.ssatweb.domain.SsatRole;
import pers.ccy.ssatweb.service.SsatRoleService;
import pers.ccy.ssatweb.vo.SsatRoleVO;

import java.util.Date;
import java.util.List;

/**
 * @author desperado
 * @ClassName SsatRoleController
 * @Description
 * @date 2020/7/4 22:03
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/role")
public class SsatRoleController {
    @Autowired
    SsatRoleService ssatRoleService;

    @GetMapping("/listAll")
    public RespBean listAll(){
        try {
            List<SsatRoleVO> list = ssatRoleService.listAll();
            return RespBean.ok("查询成功",list);
        }catch (Exception e){
            return RespBean.error("查询失败");
        }
    }

    @PostMapping("/add")
    public RespBean addUser(SsatRole ssatRole) {
        try {
            ssatRole.setAdminCount(0);
            ssatRole.setCreateTime(new Date());
            ssatRole.setStatus(1);
            ssatRoleService.insert(ssatRole);
            return RespBean.ok("添加成功");
        } catch (Exception e){
            return RespBean.error("添加失败");
        }
    }


    @GetMapping(value = "/listAllId")
    public RespBean listAllId(Long roleId){
        try {
            List<Long> list = ssatRoleService.listAllResourceIds(roleId);
            return RespBean.ok("查询成功",list);
        }catch (Exception e){
            return RespBean.error("查询失败");
        }
    }

    @PostMapping(value = "/allocResource")
    public RespBean allocResource(Long roleId, @RequestParam(value = "resourceIds") List<Long> resourceIds){
        try{
            if (roleId == 1)
                return RespBean.error("无法修改超级管理员权限");
            ssatRoleService.allocResource(roleId, resourceIds);
            return RespBean.ok("分配权限成功");
        }catch (Exception e){
            return RespBean.error("分配权限失败");
        }
    }

    @GetMapping(value = "/delete/{id}")
    public RespBean delete(@PathVariable(value = "id")Long roleId){
        try {
            if (roleId == 1)
                return RespBean.error("无法删除超级管理员");
            ssatRoleService.deleteById(roleId);
            return RespBean.ok("删除成功");
        }catch (Exception e){
            return RespBean.error("删除失败");
        }
    }

    @PostMapping(value = "/update")
    public RespBean update(SsatRole ssatRole){
        try {
            if (ssatRole.getId() == 1)
                return RespBean.error("无法修改超级管理员信息");
            ssatRoleService.update(ssatRole);
            return RespBean.ok("更新成功");
        }catch (Exception e){
            return RespBean.error("更新失败");
        }
    }
}
