package pers.ccy.ssatweb.vo;

import pers.ccy.ssatweb.domain.Menu;
import pers.ccy.ssatweb.utils.ExtractUtil;
import pers.ccy.ssatweb.utils.ModelMapperUtil;

import java.util.List;

/**
 * @author desperado
 * @ClassName MenuVO
 * @Description
 * @date 2020/5/21 10:48
 * @Version 1.0
 */
public class MenuVO extends TreeVO{
    private String name;
    private String icon;
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public static List<MenuVO> parseBy(List<Menu> list) {
        return ExtractUtil.transferToList(list, MenuVO::parseBy);
    }

    public static MenuVO parseBy(Menu menu) {
        return ModelMapperUtil.map(menu, MenuVO.class);
    }
}
