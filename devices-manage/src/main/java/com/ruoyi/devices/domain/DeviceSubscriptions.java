package com.ruoyi.devices.domain;

import java.time.LocalTime;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订阅管理对象 device_subscriptions
 * 
 * @author 尹罗飞
 * @date 2025-03-22
 */
public class DeviceSubscriptions extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private String deviceNumber;


    /** 订阅时间 */
    @JsonFormat(pattern = "HH:mm:ss")
    @Excel(name = "订阅时间", width = 30, dateFormat = "HH:mm:ss")
    private LocalTime subscriptionTime;

    private String useTime;

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }

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
    public void setSubscriptionTime(LocalTime subscriptionTime)
    {
        this.subscriptionTime = subscriptionTime;
    }

    public LocalTime getSubscriptionTime()
    {
        return subscriptionTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviceNumber", getDeviceNumber())
            .append("subscriptionTime", getSubscriptionTime())
            .toString();
    }
}
