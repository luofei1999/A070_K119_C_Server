package com.ruoyi.patient.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 患者列表对象 doctor_patient
 * 
 * @author 尹罗飞
 * @date 2025-05-07
 */
public class DoctorPatient extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "医生ID")
    private Long doctorid;

    /** 名称 */
    @Excel(name = "名称")
    private String patientname;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    /** 婚姻状态 */
    @Excel(name = "婚姻状态")
    private String martialstatus;

    /** 手机 */
    @Excel(name = "手机")
    private String phone;

    /** 街道 */
    @Excel(name = "街道")
    private String street;

    /** 城市 */
    @Excel(name = "城市")
    private String city;

    /** 州 */
    @Excel(name = "州")
    private String state;

    /** 邮政编码 */
    @Excel(name = "邮政编码")
    private String zipcode;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "最近一次治疗", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date lastTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDoctorid(Long doctorid) 
    {
        this.doctorid = doctorid;
    }

    public Long getDoctorid() 
    {
        return doctorid;
    }
    public void setPatientname(String patientname) 
    {
        this.patientname = patientname;
    }

    public String getPatientname() 
    {
        return patientname;
    }
    public void setBirthday(Date birthday) 
    {
        this.birthday = birthday;
    }

    public Date getBirthday() 
    {
        return birthday;
    }
    public void setAge(Long age) 
    {
        this.age = age;
    }

    public Long getAge() 
    {
        return age;
    }
    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }
    public void setMartialstatus(String martialstatus) 
    {
        this.martialstatus = martialstatus;
    }

    public String getMartialstatus() 
    {
        return martialstatus;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setStreet(String street) 
    {
        this.street = street;
    }

    public String getStreet() 
    {
        return street;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setZipcode(String zipcode) 
    {
        this.zipcode = zipcode;
    }

    public String getZipcode() 
    {
        return zipcode;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("doctorid", getDoctorid())
            .append("patientname", getPatientname())
            .append("birthday", getBirthday())
            .append("age", getAge())
            .append("gender", getGender())
            .append("martialstatus", getMartialstatus())
            .append("phone", getPhone())
            .append("street", getStreet())
            .append("city", getCity())
            .append("state", getState())
            .append("zipcode", getZipcode())
            .append("email", getEmail())
            .toString();
    }
}
