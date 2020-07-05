package pers.ccy.ssatweb.domain;

import java.util.Date;
import java.io.Serializable;

/**
 * (SsatResourceCategory)实体类
 *
 * @author makejava
 * @since 2020-07-02 09:24:28
 */
public class SsatResourceCategory implements Serializable {
    private static final long serialVersionUID = -58089944396754143L;
    
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
    * 排序
    */
    private Integer sort;


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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

}