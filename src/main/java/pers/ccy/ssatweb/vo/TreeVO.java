package pers.ccy.ssatweb.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author desperado
 * @ClassName TreeVO
 * @Description
 * @date 2020/6/7 16:43
 * @Version 1.0
 */
public class TreeVO implements Serializable {
    int id;
    int pid;
    private List<TreeVO> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public List<TreeVO> getChildren() {
        return children;
    }

    public void setChildren(List<TreeVO> children) {
        this.children = children;
    }
}
