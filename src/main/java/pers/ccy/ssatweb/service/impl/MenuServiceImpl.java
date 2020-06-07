package pers.ccy.ssatweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.ccy.ssatweb.common.RespBean;
import pers.ccy.ssatweb.dao.MenuDao;
import pers.ccy.ssatweb.domain.Menu;
import pers.ccy.ssatweb.service.MenuService;
import pers.ccy.ssatweb.utils.ExtractUtil;
import pers.ccy.ssatweb.utils.TreeUtil;
import pers.ccy.ssatweb.vo.MenuVO;
import pers.ccy.ssatweb.vo.TreeVO;

import java.util.List;

/**
 * @author desperado
 * @ClassName MenuServiceImpl
 * @Description
 * @date 2020/5/21 11:13
 * @Version 1.0
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuDao menuDao;

    @Override
    public RespBean findAllMenu() {
        try {
            List<Menu> list = menuDao.findAll();
            List<MenuVO> menuVOS = MenuVO.parseBy(list);
            List<MenuVO> menuVOList = TreeUtil.toTree(menuVOS);
            return RespBean.ok("查询成功",menuVOList);
        }catch (Exception e){
            return RespBean.error("查询失败");
        }
    }
}
