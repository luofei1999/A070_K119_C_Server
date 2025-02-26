package com.ruoyi.patient.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 患者资料对象 patient_info
 * 
 * @author 尹罗飞
 * @date 2025-02-26
 */
public class PatientInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 患者ID */
    @Excel(name = "患者ID")
    private Long patientId;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 姓别 */
    @Excel(name = "姓别")
    private String gender;

    /** 联系 */
    @Excel(name = "联系")
    private String contact;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 皮肤类型 */
    @Excel(name = "皮肤类型")
    private String skinType;

    /** 过敏史 */
    @Excel(name = "过敏史")
    private String historyOfSensitivity;

    /** 疾病史 */
    @Excel(name = "疾病史")
    private String pastMedicalHistory;

    public void setPatientId(Long patientId) 
    {
        this.patientId = patientId;
    }

    public Long getPatientId() 
    {
        return patientId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }
    public void setContact(String contact) 
    {
        this.contact = contact;
    }

    public String getContact() 
    {
        return contact;
    }
    public void setDate(Date date) 
    {
        this.date = date;
    }

    public Date getDate() 
    {
        return date;
    }
    public void setAge(Long age) 
    {
        this.age = age;
    }

    public Long getAge() 
    {
        return age;
    }
    public void setSkinType(String skinType) 
    {
        this.skinType = skinType;
    }

    public String getSkinType() 
    {
        return skinType;
    }
    public void setHistoryOfSensitivity(String historyOfSensitivity) 
    {
        this.historyOfSensitivity = historyOfSensitivity;
    }

    public String getHistoryOfSensitivity() 
    {
        return historyOfSensitivity;
    }
    public void setPastMedicalHistory(String pastMedicalHistory) 
    {
        this.pastMedicalHistory = pastMedicalHistory;
    }

    public String getPastMedicalHistory() 
    {
        return pastMedicalHistory;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("patientId", getPatientId())
            .append("name", getName())
            .append("gender", getGender())
            .append("contact", getContact())
            .append("date", getDate())
            .append("age", getAge())
            .append("skinType", getSkinType())
            .append("historyOfSensitivity", getHistoryOfSensitivity())
            .append("pastMedicalHistory", getPastMedicalHistory())
            .toString();
    }
}
