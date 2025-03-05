package com.ruoyi.patient.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 治疗图片对象 treatment_images
 * 
 * @author 尹罗飞
 * @date 2025-03-05
 */
public class TreatmentImages extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 治疗ID */
    @Excel(name = "治疗ID")
    private Long treatmentId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /** 用户ID */
    @Excel(name = "用户名")
    private String userName;

    /** 文件名称 */
    @Excel(name = "文件名称")
    private String name;

    /** 访问路径 */
    @Excel(name = "访问路径")
    private String path;

    /** 访问地址 */
    @Excel(name = "访问地址")
    private String url;

    /** 访问地址 是否治疗后(0=治疗前, 1=治疗后) */
    @Excel(name = "图片标识")
    private String isTreatmentAfter;

    public String getIsTreatmentAfter() {
        return isTreatmentAfter;
    }

    public void setIsTreatmentAfter(String isTreatmentAfter) {
        this.isTreatmentAfter = isTreatmentAfter;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTreatmentId(Long treatmentId) 
    {
        this.treatmentId = treatmentId;
    }

    public Long getTreatmentId() 
    {
        return treatmentId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPath(String path) 
    {
        this.path = path;
    }

    public String getPath() 
    {
        return path;
    }
    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("treatmentId", getTreatmentId())
            .append("userId", getUserId())
            .append("name", getName())
            .append("path", getPath())
            .append("url", getUrl())
            .append("createTime", getCreateTime())
            .toString();
    }
}
