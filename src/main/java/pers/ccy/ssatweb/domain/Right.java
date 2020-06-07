package pers.ccy.ssatweb.domain;

import java.io.Serializable;

/**
 * @author desperado
 * @ClassName Right
 * @Description
 * @date 2020/6/7 16:22
 * @Version 1.0
 */
public class Right implements Serializable {
    private Integer id;
    private String name;
    private String path;
    private Integer level;
    private Integer pid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
