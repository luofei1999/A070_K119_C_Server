package com.ruoyi.patient.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 血氧仪对象 oximeter_data
 * 
 * @author 尹罗飞
 * @date 2025-02-26
 */
public class OximeterData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 血氧仪ID */
    private Long oximeterId;

    /** 患者ID */
    private Long patientId;

    /** 患者 */
    @Excel(name = "患者")
    private String patientName;

    /** 血氧饱和度 */
    @Excel(name = "血氧饱和度")
    private Long spo2;

    /** 脉率 */
    @Excel(name = "脉率")
    private Long pr;

    /** 血压 */
    @Excel(name = "血压")
    private Float pi;

    public void setOximeterId(Long oximeterId) 
    {
        this.oximeterId = oximeterId;
    }

    public Long getOximeterId() 
    {
        return oximeterId;
    }
    public void setPatientId(Long patientId) 
    {
        this.patientId = patientId;
    }

    public Long getPatientId() 
    {
        return patientId;
    }
    public void setPatientName(String patientName) 
    {
        this.patientName = patientName;
    }

    public String getPatientName() 
    {
        return patientName;
    }
    public void setSpo2(Long spo2) 
    {
        this.spo2 = spo2;
    }

    public Long getSpo2() 
    {
        return spo2;
    }
    public void setPr(Long pr) 
    {
        this.pr = pr;
    }

    public Long getPr() 
    {
        return pr;
    }
    public void setPi(Float pi)
    {
        this.pi = pi;
    }

    public Float getPi()
    {
        return pi;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("oximeterId", getOximeterId())
            .append("patientId", getPatientId())
            .append("patientName", getPatientName())
            .append("spo2", getSpo2())
            .append("pr", getPr())
            .append("pi", getPi())
            .append("createTime", getCreateTime())
            .toString();
    }
}
