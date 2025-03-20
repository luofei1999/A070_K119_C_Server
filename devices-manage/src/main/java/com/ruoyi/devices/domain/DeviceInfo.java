package com.ruoyi.devices.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备信息对象 device_info
 * 
 * @author 尹罗飞
 * @date 2025-03-20
 */
public class DeviceInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 编号 */
    @Excel(name = "编号")
    private String deviceNumber;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 用户 */
    @Excel(name = "用户")
    private String userName;

    /** 通信时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "通信时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date communicationTime;

    /** 流量卡号 */
    @Excel(name = "流量卡号")
    private String simCardNumber;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDeviceNumber(String deviceNumber) 
    {
        this.deviceNumber = deviceNumber;
    }

    public String getDeviceNumber() 
    {
        return deviceNumber;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setCommunicationTime(Date communicationTime) 
    {
        this.communicationTime = communicationTime;
    }

    public Date getCommunicationTime() 
    {
        return communicationTime;
    }
    public void setSimCardNumber(String simCardNumber) 
    {
        this.simCardNumber = simCardNumber;
    }

    public String getSimCardNumber() 
    {
        return simCardNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviceNumber", getDeviceNumber())
            .append("status", getStatus())
            .append("userName", getUserName())
            .append("communicationTime", getCommunicationTime())
            .append("simCardNumber", getSimCardNumber())
            .toString();
    }
}
