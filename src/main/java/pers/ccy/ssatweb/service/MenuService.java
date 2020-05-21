package pers.ccy.ssatweb.service;

import pers.ccy.ssatweb.vo.MenuVO;

import java.util.List;

/**
 * @author desperado
 * @ClassName MenuService
 * @Description
 * @date 2020/5/21 11:13
 * @Version 1.0
 */
public interface MenuService {
    /**
     * 查询菜单列表
     *
     * @MethodName findAllMenu
     * @Description
     * @param []
     */
    public List<MenuVO> findAllMenu();
}
