package pers.ccy.ssatweb.vo;

import pers.ccy.ssatweb.domain.Right;
import pers.ccy.ssatweb.utils.ExtractUtil;
import pers.ccy.ssatweb.utils.ModelMapperUtil;

import java.util.List;

/**
 * @author desperado
 * @ClassName RightVO
 * @Description
 * @date 2020/6/7 16:23
 * @Version 1.0
 */
public class RightVO extends TreeVO{
    private String name;
    private Integer level;
    private String descritpion;
    private String frontpath;
    private String endpath;

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public static List<RightVO> parseBy(List<Right> list) {
        return ExtractUtil.transferToList(list, RightVO::parseBy);
    }

    public static RightVO parseBy(Right right) {
        return ModelMapperUtil.map(right, RightVO.class);
    }

    public String getFrontpath() {
        return frontpath;
    }

    public void setFrontpath(String frontpath) {
        this.frontpath = frontpath;
    }

    public String getEndpath() {
        return endpath;
    }

    public void setEndpath(String endpath) {
        this.endpath = endpath;
    }
}
