package pers.ccy.ssatweb.vo;

import java.util.Date;

/**
 * @author desperado
 * @ClassName SsatResourceVO
 * @Description
 * @date 2020/7/4 23:15
 * @Version 1.0
 */
public class SsatResourceVO {
    private Long id;
    /**
     * 资源分类ID
     */
    private Long categoryId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 资源名称
     */
    private String name;
    /**
     * 资源URL
     */
    private String url;
    /**
     * 描述
     */
    private String description;
    /**
     * 所属目录名称
     */
    private String categoryName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
