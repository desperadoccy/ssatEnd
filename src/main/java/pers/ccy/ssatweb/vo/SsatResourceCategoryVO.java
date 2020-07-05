package pers.ccy.ssatweb.vo;

import pers.ccy.ssatweb.domain.SsatResource;

import java.util.Date;
import java.util.List;

/**
 * @author desperado
 * @ClassName SsatResourceCategoryVO
 * @Description
 * @date 2020/7/5 10:04
 * @Version 1.0
 */
public class SsatResourceCategoryVO {
    private Long id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 权限集合
     */
    private List<SsatResource> resources;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SsatResource> getResources() {
        return resources;
    }

    public void setResources(List<SsatResource> resources) {
        this.resources = resources;
    }


}
