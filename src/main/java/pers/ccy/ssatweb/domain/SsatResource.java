package pers.ccy.ssatweb.domain;

import pers.ccy.ssatweb.utils.ModelMapperUtil;
import pers.ccy.ssatweb.vo.SsatResourceVO;

import java.util.Date;
import java.io.Serializable;

/**
 * (SsatResource)实体类
 *
 * @author makejava
 * @since 2020-07-02 09:24:13
 */
public class SsatResource implements Serializable {
    private static final long serialVersionUID = 647997591410877272L;
    
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

    public static SsatResource parseBy(SsatResourceVO ssatResourceVO) {
        return ModelMapperUtil.map(ssatResourceVO, SsatResource.class);
    }
}