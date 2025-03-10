package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 应用更新对象 app_updates
 * 
 * @author 尹罗飞
 * @date 2025-03-10
 */
public class AppUpdates extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增 ID */
    private Long id;

    /** 应用名称 */
    @Excel(name = "应用名称")
    private String appName;

    /** 版本号（整数，如 100） */
    @Excel(name = "版本号", readConverterExp = "整=数，如,1=00")
    private Long versionCode;

    /** 版本名称（如 1.0.0） */
    @Excel(name = "版本名称", readConverterExp = "如=,1=.0.0")
    private String versionName;

    /** 更新类型（0=可选更新，1=强制更新） */
    @Excel(name = "更新类型", readConverterExp = "0==可选更新，1=强制更新")
    private Integer updateType;

    /** 更新描述（更新内容） */
    @Excel(name = "更新描述", readConverterExp = "更=新内容")
    private String updateDesc;

    /** APK 下载地址 */
    @Excel(name = "APK 下载地址")
    private String apkUrl;

    /** APK 文件大小（单位：字节） */
    @Excel(name = "APK 文件大小", readConverterExp = "单=位：字节")
    private Long apkSize;

    /** APK 文件 MD5 值（用于校验完整性） */
    @Excel(name = "APK 文件 MD5 值", readConverterExp = "用=于校验完整性")
    private String md5;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAppName(String appName) 
    {
        this.appName = appName;
    }

    public String getAppName() 
    {
        return appName;
    }
    public void setVersionCode(Long versionCode) 
    {
        this.versionCode = versionCode;
    }

    public Long getVersionCode() 
    {
        return versionCode;
    }
    public void setVersionName(String versionName) 
    {
        this.versionName = versionName;
    }

    public String getVersionName() 
    {
        return versionName;
    }
    public void setUpdateType(Integer updateType) 
    {
        this.updateType = updateType;
    }

    public Integer getUpdateType() 
    {
        return updateType;
    }
    public void setUpdateDesc(String updateDesc) 
    {
        this.updateDesc = updateDesc;
    }

    public String getUpdateDesc() 
    {
        return updateDesc;
    }
    public void setApkUrl(String apkUrl) 
    {
        this.apkUrl = apkUrl;
    }

    public String getApkUrl() 
    {
        return apkUrl;
    }
    public void setApkSize(Long apkSize) 
    {
        this.apkSize = apkSize;
    }

    public Long getApkSize() 
    {
        return apkSize;
    }
    public void setMd5(String md5) 
    {
        this.md5 = md5;
    }

    public String getMd5() 
    {
        return md5;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("appName", getAppName())
            .append("versionCode", getVersionCode())
            .append("versionName", getVersionName())
            .append("updateType", getUpdateType())
            .append("updateDesc", getUpdateDesc())
            .append("apkUrl", getApkUrl())
            .append("apkSize", getApkSize())
            .append("md5", getMd5())
            .append("createTime", getCreateTime())
            .toString();
    }
}
