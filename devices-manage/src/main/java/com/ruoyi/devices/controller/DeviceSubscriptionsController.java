package com.ruoyi.devices.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.annotation.Anonymous;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.devices.domain.DeviceSubscriptions;
import com.ruoyi.devices.service.IDeviceSubscriptionsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订阅管理Controller
 * 
 * @author 尹罗飞
 * @date 2025-03-22
 */
@RestController
@RequestMapping("/devices/subscriptions_manage")
public class DeviceSubscriptionsController extends BaseController
{
    @Autowired
    private IDeviceSubscriptionsService deviceSubscriptionsService;

    /**
     * 查询订阅管理列表
     */
    @PreAuthorize("@ss.hasPermi('devices:subscriptions_manage:list')")
    @GetMapping("/list")
    public TableDataInfo list(DeviceSubscriptions deviceSubscriptions)
    {
        startPage();
        List<DeviceSubscriptions> list = deviceSubscriptionsService.selectDeviceSubscriptionsList(deviceSubscriptions);
        return getDataTable(list);
    }

    /**
     * 导出订阅管理列表
     */
    @PreAuthorize("@ss.hasPermi('devices:subscriptions_manage:export')")
    @Log(title = "订阅管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DeviceSubscriptions deviceSubscriptions)
    {
        List<DeviceSubscriptions> list = deviceSubscriptionsService.selectDeviceSubscriptionsList(deviceSubscriptions);
        ExcelUtil<DeviceSubscriptions> util = new ExcelUtil<DeviceSubscriptions>(DeviceSubscriptions.class);
        util.exportExcel(response, list, "订阅管理数据");
    }

    /**
     * 获取订阅管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('devices:subscriptions_manage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(deviceSubscriptionsService.selectDeviceSubscriptionsById(id));
    }

    /**
     * 新增订阅管理
     */
    @PreAuthorize("@ss.hasPermi('devices:subscriptions_manage:add')")
    @Log(title = "订阅管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DeviceSubscriptions deviceSubscriptions)
    {
        return toAjax(deviceSubscriptionsService.insertDeviceSubscriptions(deviceSubscriptions));
    }

    /**
     * 修改订阅管理
     */
    @PreAuthorize("@ss.hasPermi('devices:subscriptions_manage:edit')")
    @Log(title = "订阅管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DeviceSubscriptions deviceSubscriptions)
    {
        return toAjax(deviceSubscriptionsService.updateDeviceSubscriptions(deviceSubscriptions));
    }

    /**
     * 删除订阅管理
     */
    @PreAuthorize("@ss.hasPermi('devices:subscriptions_manage:remove')")
    @Log(title = "订阅管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(deviceSubscriptionsService.deleteDeviceSubscriptionsByIds(ids));
    }

    /**
     * 添加设备
     */
    @Anonymous
    @PostMapping("/add")
    public AjaxResult addDeviceNumber(@RequestBody DeviceSubscriptions deviceSubscriptions)
    {
        System.out.println(deviceSubscriptions.getUseTime());
        return toAjax(deviceSubscriptionsService.addSubscriptionsDevice(deviceSubscriptions));
    }

    /**
     * 根据设备号查询订阅信息
     */
    @GetMapping("/query/{deviceNumber}")
    @Anonymous
    public AjaxResult getSubscriptionByDeviceNumber(@PathVariable("deviceNumber") String deviceNumber) {
        DeviceSubscriptions subscription = deviceSubscriptionsService.selectSubscriptionsByDeviceNumber(deviceNumber);
        if (subscription == null) {
            return AjaxResult.error("Device subscription not found for device: " + deviceNumber);
        }
        return AjaxResult.success(subscription);
    }

}
