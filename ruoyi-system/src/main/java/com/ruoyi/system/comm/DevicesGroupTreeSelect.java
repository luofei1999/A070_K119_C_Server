package com.ruoyi.system.comm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.entity.SysMenu;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysDevicesGroup;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Treeselect树结构实体类
 * 
 * @author ruoyi
 */
public class DevicesGroupTreeSelect implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 节点ID */
    private Long id;

    /** 节点名称 */
    private String label;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    /** 备注 */
    private String remark;

    /** 节点禁用 */
    private boolean disabled = false;

    /** 子节点 */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DevicesGroupTreeSelect> children;

    public DevicesGroupTreeSelect()
    {

    }

    public DevicesGroupTreeSelect(SysDevicesGroup group)
    {
        this.id = group.getGroupId();
        this.label = group.getGroupName();
        this.remark = group.getRemark();
        this.disabled = StringUtils.equals(UserConstants.DEPT_DISABLE, group.getStatus());
        this.children = group.getChildren().stream().map(DevicesGroupTreeSelect::new).collect(Collectors.toList());
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public boolean isDisabled()
    {
        return disabled;
    }

    public void setDisabled(boolean disabled)
    {
        this.disabled = disabled;
    }

    public List<DevicesGroupTreeSelect> getChildren()
    {
        return children;
    }

    public void setChildren(List<DevicesGroupTreeSelect> children)
    {
        this.children = children;
    }
}
