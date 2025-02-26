package com.ruoyi.patient.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 治疗记录对象 treatment_record
 * 
 * @author 尹罗飞
 * @date 2025-02-26
 */
public class TreatmentRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 治疗记录ID */
    private Long id;

    /** 患者ID */
    private Long patientId;

    /** 患者名称 */
    @Excel(name = "患者名称")
    private String patientName;

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    /** 治疗方案 */
    @Excel(name = "治疗方案")
    private String treatmentPlan;

    /** 治疗时长 */
    @Excel(name = "治疗时长")
    private String treatmentDuration;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date treatmentStartTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date treatmentEndTime;

    /** 治疗能量 */
    @Excel(name = "治疗能量")
    private BigDecimal treatmentEnergy;

    /** 总能量输出 */
    @Excel(name = "总能量输出")
    private BigDecimal totalEnergyOutput;

    /** 治疗设备 */
    @Excel(name = "治疗设备")
    private String treatmentDevice;

    /** 治疗地址 */
    @Excel(name = "治疗地址")
    private String treatmentLocation;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPatientId(Long patientId) 
    {
        this.patientId = patientId;
    }

    public Long getPatientId() 
    {
        return patientId;
    }
    public void setTreatmentPlan(String treatmentPlan) 
    {
        this.treatmentPlan = treatmentPlan;
    }

    public String getTreatmentPlan() 
    {
        return treatmentPlan;
    }
    public void setTreatmentDuration(String treatmentDuration) 
    {
        this.treatmentDuration = treatmentDuration;
    }

    public String getTreatmentDuration() 
    {
        return treatmentDuration;
    }
    public void setTreatmentStartTime(Date treatmentStartTime) 
    {
        this.treatmentStartTime = treatmentStartTime;
    }

    public Date getTreatmentStartTime() 
    {
        return treatmentStartTime;
    }
    public void setTreatmentEndTime(Date treatmentEndTime) 
    {
        this.treatmentEndTime = treatmentEndTime;
    }

    public Date getTreatmentEndTime() 
    {
        return treatmentEndTime;
    }
    public void setTreatmentEnergy(BigDecimal treatmentEnergy) 
    {
        this.treatmentEnergy = treatmentEnergy;
    }

    public BigDecimal getTreatmentEnergy() 
    {
        return treatmentEnergy;
    }
    public void setTotalEnergyOutput(BigDecimal totalEnergyOutput) 
    {
        this.totalEnergyOutput = totalEnergyOutput;
    }

    public BigDecimal getTotalEnergyOutput() 
    {
        return totalEnergyOutput;
    }
    public void setTreatmentDevice(String treatmentDevice) 
    {
        this.treatmentDevice = treatmentDevice;
    }

    public String getTreatmentDevice() 
    {
        return treatmentDevice;
    }
    public void setTreatmentLocation(String treatmentLocation) 
    {
        this.treatmentLocation = treatmentLocation;
    }

    public String getTreatmentLocation() 
    {
        return treatmentLocation;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("patientId", getPatientId())
            .append("treatmentPlan", getTreatmentPlan())
            .append("treatmentDuration", getTreatmentDuration())
            .append("treatmentStartTime", getTreatmentStartTime())
            .append("treatmentEndTime", getTreatmentEndTime())
            .append("treatmentEnergy", getTreatmentEnergy())
            .append("totalEnergyOutput", getTotalEnergyOutput())
            .append("treatmentDevice", getTreatmentDevice())
            .append("treatmentLocation", getTreatmentLocation())
            .toString();
    }
}
