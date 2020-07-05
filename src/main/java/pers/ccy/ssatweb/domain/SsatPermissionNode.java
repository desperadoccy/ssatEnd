package pers.ccy.ssatweb.domain;

import java.util.List;

/**
 * @author desperado
 * @ClassName SsatPermissionNode
 * @Description
 * @date 2020/7/3 15:16
 * @Version 1.0
 */
public class SsatPermissionNode extends SsatPermission {

    private List<SsatPermissionNode> children;

    public List<SsatPermissionNode> getChildren() {
        return children;
    }

    public void setChildren(List<SsatPermissionNode> children) {
        this.children = children;
    }
}
