package com.ruoyi.devices.mapper;

import java.util.List;
import com.ruoyi.devices.domain.DeviceSubscriptions;

/**
 * 订阅管理Mapper接口
 * 
 * @author 尹罗飞
 * @date 2025-03-22
 */
public interface DeviceSubscriptionsMapper 
{
    /**
     * 查询订阅管理
     * 
     * @param id 订阅管理主键
     * @return 订阅管理
     */
    public DeviceSubscriptions selectDeviceSubscriptionsById(Long id);
    /**
     * 设备编号查询
     *
     * @param deviceNumber 订阅管理主键
     * @return 订阅管理
     */
    public DeviceSubscriptions selectDeviceSubscriptionsByDeviceNumber(String deviceNumber);

    /**
     * 查询订阅管理列表
     * 
     * @param deviceSubscriptions 订阅管理
     * @return 订阅管理集合
     */
    public List<DeviceSubscriptions> selectDeviceSubscriptionsList(DeviceSubscriptions deviceSubscriptions);

    /**
     * 新增订阅管理
     * 
     * @param deviceSubscriptions 订阅管理
     * @return 结果
     */
    public int insertDeviceSubscriptions(DeviceSubscriptions deviceSubscriptions);

    /**
     * 修改订阅管理
     * 
     * @param deviceSubscriptions 订阅管理
     * @return 结果
     */
    public int updateDeviceSubscriptions(DeviceSubscriptions deviceSubscriptions);

    /**
     * 删除订阅管理
     * 
     * @param id 订阅管理主键
     * @return 结果
     */
    public int deleteDeviceSubscriptionsById(Long id);

    /**
     * 批量删除订阅管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDeviceSubscriptionsByIds(Long[] ids);


}
