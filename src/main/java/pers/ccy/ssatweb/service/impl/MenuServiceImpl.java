package pers.ccy.ssatweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.ccy.ssatweb.dao.MenuDao;
import pers.ccy.ssatweb.domain.Menu;
import pers.ccy.ssatweb.service.MenuService;
import pers.ccy.ssatweb.utils.ExtractUtil;
import pers.ccy.ssatweb.utils.TreeUtil;
import pers.ccy.ssatweb.vo.MenuVO;

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
    public List<MenuVO> findAllMenu() {
        List<Menu> list = menuDao.findAll();
        List<MenuVO> menuVOS = MenuVO.parseBy(list);
        return TreeUtil.toTree(menuVOS);
    }
}
