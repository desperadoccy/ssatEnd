package pers.ccy.ssatweb.utils;

import pers.ccy.ssatweb.vo.MenuVO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author desperado
 * @ClassName TreeUtil
 * @Description
 * @date 2020/5/21 10:50
 * @Version 1.0
 */
public class TreeUtil {
    private static List<MenuVO> all = null;

    public static List<MenuVO> toTree(List<MenuVO> list) {
        all = new ArrayList<>(list);
        List<MenuVO> roots = new ArrayList<>();
        for (MenuVO menuVo : list) {
            if (menuVo.getPid() == 0)
                roots.add(menuVo);
        }

        all.removeAll(roots);
        for (MenuVO menuVO : roots) {
            menuVO.setChildren(getCurrentNodeChildren(menuVO));
        }
        return roots;
    }

    public static List<MenuVO> getCurrentNodeChildren(MenuVO parent) {
        List<MenuVO> childList = parent.getChildren() == null ? new ArrayList<>() : parent.getChildren();
        for (MenuVO child : all) {
            if (parent.getId() == child.getPid()) {
                childList.add(child);
            }
        }

        all.removeAll(childList);
        for (MenuVO menuVO : childList) {
            menuVO.setChildren(getCurrentNodeChildren(menuVO));
        }
        return childList;
    }
}
