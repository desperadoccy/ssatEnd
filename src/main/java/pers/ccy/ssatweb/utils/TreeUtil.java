package pers.ccy.ssatweb.utils;

import pers.ccy.ssatweb.vo.TreeVO;

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
    private static List<? extends TreeVO> all = null;

    public static <T extends TreeVO> List<T> toTree(List<T> list) {
        all = new ArrayList<>(list);
        List<T> roots = new ArrayList<>();
        for (T treeVO : list) {
            if (treeVO.getPid() == 0)
                roots.add(treeVO);
        }

        all.removeAll(roots);
        for (TreeVO treeVO : roots) {
            treeVO.setChildren(getCurrentNodeChildren(treeVO));
        }
        return roots;
    }

    public static <T extends TreeVO> List<T> getCurrentNodeChildren(T parent) {
        List<T> childList = parent.getChildren() == null ? new ArrayList<>() : (List<T>) parent.getChildren();
        for (TreeVO child : all) {
            if (parent.getId() == child.getPid()) {
                childList.add((T)child);
            }
        }

        all.removeAll(childList);
        for (TreeVO treeVO : childList) {
            treeVO.setChildren(getCurrentNodeChildren(treeVO));
        }
        return childList;
    }
}
