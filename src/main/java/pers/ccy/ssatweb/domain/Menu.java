package pers.ccy.ssatweb.domain;

import java.io.Serializable;

/**
 * @author desperado
 * @ClassName Menu
 * @Description
 * @date 2020/5/20 23:44
 * @Version 1.0
 */
public class Menu implements Serializable {
    private Integer id;
    private Integer pid;
    private String name;
    private String icon;
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
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
}
