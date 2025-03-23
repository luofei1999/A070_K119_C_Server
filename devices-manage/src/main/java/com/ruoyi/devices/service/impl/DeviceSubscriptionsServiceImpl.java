package com.ruoyi.devices.service.impl;

import java.time.LocalTime;
import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.devices.mapper.DeviceSubscriptionsMapper;
import com.ruoyi.devices.domain.DeviceSubscriptions;
import com.ruoyi.devices.service.IDeviceSubscriptionsService;

/**
 * 订阅管理Service业务层处理
 * 
 * @author 尹罗飞
 * @date 2025-03-22
 */
@Service
public class DeviceSubscriptionsServiceImpl implements IDeviceSubscriptionsService 
{
    @Autowired
    private DeviceSubscriptionsMapper deviceSubscriptionsMapper;

    /**
     * 查询订阅管理
     * 
     * @param id 订阅管理主键
     * @return 订阅管理
     */
    @Override
    public DeviceSubscriptions selectDeviceSubscriptionsById(Long id)
    {
        return deviceSubscriptionsMapper.selectDeviceSubscriptionsById(id);
    }

    @Override
    public DeviceSubscriptions selectSubscriptionsByDeviceNumber(String deviceNumber) {
        return deviceSubscriptionsMapper.selectDeviceSubscriptionsByDeviceNumber(deviceNumber);
    }

    /**
     * 查询订阅管理列表
     * 
     * @param deviceSubscriptions 订阅管理
     * @return 订阅管理
     */
    @Override
    public List<DeviceSubscriptions> selectDeviceSubscriptionsList(DeviceSubscriptions deviceSubscriptions)
    {
        return deviceSubscriptionsMapper.selectDeviceSubscriptionsList(deviceSubscriptions);
    }

    /**
     * 新增订阅管理
     * 
     * @param deviceSubscriptions 订阅管理
     * @return 结果
     */
    @Override
    public int insertDeviceSubscriptions(DeviceSubscriptions deviceSubscriptions)
    {
        return deviceSubscriptionsMapper.insertDeviceSubscriptions(deviceSubscriptions);
    }

    /**
     * 修改订阅管理
     * 
     * @param deviceSubscriptions 订阅管理
     * @return 结果
     */
    @Override
    public int updateDeviceSubscriptions(DeviceSubscriptions deviceSubscriptions)
    {
        return deviceSubscriptionsMapper.updateDeviceSubscriptions(deviceSubscriptions);
    }

    /**
     * 批量删除订阅管理
     * 
     * @param ids 需要删除的订阅管理主键
     * @return 结果
     */
    @Override
    public int deleteDeviceSubscriptionsByIds(Long[] ids)
    {
        return deviceSubscriptionsMapper.deleteDeviceSubscriptionsByIds(ids);
    }

    /**
     * 删除订阅管理信息
     * 
     * @param id 订阅管理主键
     * @return 结果
     */
    @Override
    public int deleteDeviceSubscriptionsById(Long id)
    {
        return deviceSubscriptionsMapper.deleteDeviceSubscriptionsById(id);
    }

    @Override
    public int addSubscriptionsDevice(DeviceSubscriptions deviceSubscriptions) {

        DeviceSubscriptions device = deviceSubscriptionsMapper.selectDeviceSubscriptionsByDeviceNumber(deviceSubscriptions.getDeviceNumber());

        if (device != null) {

            String useTime = deviceSubscriptions.getUseTime();
            // 有使用时间，更新订阅时间
            if (useTime != null && Integer.parseInt(useTime) != 0) {
                updateSubscriptionsByDeviceNumber(deviceSubscriptions.getDeviceNumber(), deviceSubscriptions.getUseTime());
            }

            return 1; // Device already exists, return success
        }
        // Set subscription time to 0
        deviceSubscriptions.setSubscriptionTime(LocalTime.of(0, 0, 0));
        return insertDeviceSubscriptions(deviceSubscriptions);
    }

    /**
     * Update subscription time by device number
     * @param deviceNumber 设备编号
     * @param treatmentTime 治疗时间
     */
    @Override
    public void updateSubscriptionsByDeviceNumber(String deviceNumber, String treatmentTime) {

        // Find device subscription by device number
        DeviceSubscriptions subscription = deviceSubscriptionsMapper.selectDeviceSubscriptionsByDeviceNumber(deviceNumber);
        if (subscription == null) {
            throw new ServiceException("Device subscription not found for device: " + deviceNumber);
        }

        // Get current subscription time
        LocalTime currentTime = subscription.getSubscriptionTime();
        if (currentTime == null) {
            throw new ServiceException("Invalid subscription time for device: " + deviceNumber);
        }

        try {
            // Convert treatment time from seconds to duration
            int seconds = Integer.parseInt(treatmentTime);

            LocalTime remainingTime = currentTime.minusSeconds(seconds);

            // Update subscription with remaining time
            subscription.setSubscriptionTime(remainingTime);
            deviceSubscriptionsMapper.updateDeviceSubscriptions(subscription);
        } catch (NumberFormatException e) {
            throw new ServiceException("Invalid treatment time format: " + treatmentTime);
        } catch (Exception e) {
            throw new ServiceException("Error updating subscription time: " + e.getMessage());
        }
    }

}
