package com.ruoyi.devices.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.system.domain.SysDevicesGroup;
import com.ruoyi.system.service.ISysDevicesGroupService;
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
import com.ruoyi.devices.domain.DeviceInfo;
import com.ruoyi.devices.service.IDeviceInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备信息Controller
 * 
 * @author 尹罗飞
 * @date 2025-03-20
 */
@RestController
@RequestMapping("/devices/devices_manage")
public class DeviceInfoController extends BaseController
{
    @Autowired
    private IDeviceInfoService deviceInfoService;
    @Autowired
    private ISysDevicesGroupService sysDevicesGroupService;

    /**
     * 查询设备信息列表
     */
    @PreAuthorize("@ss.hasPermi('devices:devices_manage:list')")
    @GetMapping("/list")
    public TableDataInfo list(DeviceInfo deviceInfo)
    {
        startPage();
        List<DeviceInfo> list = deviceInfoService.selectDeviceInfoList(deviceInfo);
        return getDataTable(list);
    }

    /**
     * 导出设备信息列表
     */
    @PreAuthorize("@ss.hasPermi('devices:devices_manage:export')")
    @Log(title = "设备信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DeviceInfo deviceInfo)
    {
        List<DeviceInfo> list = deviceInfoService.selectDeviceInfoList(deviceInfo);
        ExcelUtil<DeviceInfo> util = new ExcelUtil<DeviceInfo>(DeviceInfo.class);
        util.exportExcel(response, list, "设备信息数据");
    }

    /**
     * 获取设备信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('devices:devices_manage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(deviceInfoService.selectDeviceInfoById(id));
    }

    /**
     * 新增设备信息
     */
    @PreAuthorize("@ss.hasPermi('devices:devices_manage:add')")
    @Log(title = "设备信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DeviceInfo deviceInfo)
    {
        return toAjax(deviceInfoService.insertDeviceInfo(deviceInfo));
    }

    /**
     * 修改设备信息
     */
    @PreAuthorize("@ss.hasPermi('devices:devices_manage:edit')")
    @Log(title = "设备信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DeviceInfo deviceInfo)
    {
        return toAjax(deviceInfoService.updateDeviceInfo(deviceInfo));
    }

    /**
     * 删除设备信息
     */
    @PreAuthorize("@ss.hasPermi('devices:devices_manage:remove')")
    @Log(title = "设备信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(deviceInfoService.deleteDeviceInfoByIds(ids));
    }

    /**
     * 获取设备分组树列表
     */
    @PreAuthorize("@ss.hasPermi('system:user:list')")
    @GetMapping("/devicesGroupTree")
    public AjaxResult groupTree(SysDevicesGroup group)
    {
        return success(sysDevicesGroupService.selectSysDevicesGroupTreeList(group));
    }
}
