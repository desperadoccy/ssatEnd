package pers.ccy.ssatweb.vo;

import pers.ccy.ssatweb.domain.SsatResource;
import pers.ccy.ssatweb.domain.SsatRole;
import pers.ccy.ssatweb.utils.ExtractUtil;
import pers.ccy.ssatweb.utils.ModelMapperUtil;

import java.security.Permission;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author desperado
 * @ClassName SsatRoleVO
 * @Description
 * @date 2020/7/4 22:12
 * @Version 1.0
 */
public class SsatRoleVO {
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String description;
    /**
     * 后台用户数量
     */
    private Integer adminCount;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 启用状态：0->禁用；1->启用
     */
    private Integer status;

    private Integer sort;

    private Map<String,List<SsatResourceVO>> category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAdminCount() {
        return adminCount;
    }

    public void setAdminCount(Integer adminCount) {
        this.adminCount = adminCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Map<String, List<SsatResourceVO>> getCategory() {
        return category;
    }

    public void setCategory(Map<String, List<SsatResourceVO>> category) {
        this.category = category;
    }

    public static SsatRoleVO parseBy(SsatRole role, Map<String,List<SsatResourceVO>> category) {
        SsatRoleVO roleVO = ModelMapperUtil.map(role, SsatRoleVO.class);
        roleVO.setCategory(category);
        return roleVO;
    }

}
