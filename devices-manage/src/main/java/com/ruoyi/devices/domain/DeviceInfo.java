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
    private Long groupId;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Excel(name = "通信时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm")
    private Date communicationTime;

    /** 流量卡号 */
    @Excel(name = "流量卡号")
    private String simCardNumber;

    @Excel(name = "账号")
    private String account;

    @Excel(name = "密码")
    private String password;

    @Excel(name = "类型")
    private String type;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFunction1Balance() {
        return function1Balance;
    }

    public void setFunction1Balance(String function1Balance) {
        this.function1Balance = function1Balance;
    }

    @Excel(name = "功能1剩余")
    private String function1Balance;
    @Excel(name = "功能1调整")
    private String function1Adjustment;

    @Excel(name = "功能2剩余")
    private String function2Balance;

    public String getFunction1Adjustment() {
        return function1Adjustment;
    }

    public void setFunction1Adjustment(String function1Adjustment) {
        this.function1Adjustment = function1Adjustment;
    }

    public String getFunction2Balance() {
        return function2Balance;
    }

    public void setFunction2Balance(String function2Balance) {
        this.function2Balance = function2Balance;
    }

    public String getFunction2Adjustment() {
        return function2Adjustment;
    }

    public void setFunction2Adjustment(String function2Adjustment) {
        this.function2Adjustment = function2Adjustment;
    }

    public String getFunction3Balance() {
        return function3Balance;
    }

    public void setFunction3Balance(String function3Balance) {
        this.function3Balance = function3Balance;
    }

    public String getFunction3Adjustment() {
        return function3Adjustment;
    }

    public void setFunction3Adjustment(String function3Adjustment) {
        this.function3Adjustment = function3Adjustment;
    }

    @Excel(name = "功能2调整")
    private String function2Adjustment;

    @Excel(name = "功能3剩余")
    private String function3Balance;
    @Excel(name = "功能3调整")
    private String function3Adjustment;


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
