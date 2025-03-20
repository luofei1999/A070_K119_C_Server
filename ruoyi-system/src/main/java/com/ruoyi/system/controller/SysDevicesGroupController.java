package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.utils.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
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
import com.ruoyi.system.domain.SysDevicesGroup;
import com.ruoyi.system.service.ISysDevicesGroupService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备分组Controller
 * 
 * @author 尹罗飞
 * @date 2025-03-20
 */
@RestController
@RequestMapping("/system/devices_group")
public class SysDevicesGroupController extends BaseController
{
    @Autowired
    private ISysDevicesGroupService sysDevicesGroupService;

    /**
     * 查询设备分组列表
     */
    @PreAuthorize("@ss.hasPermi('system:devices_group:list')")
    @GetMapping("/list")
    public AjaxResult list(SysDevicesGroup sysDevicesGroup)
    {
        startPage();
        List<SysDevicesGroup> list = sysDevicesGroupService.selectSysDevicesGroupList(sysDevicesGroup);
        return success(list);
    }

    /**
     * 查询分组列表（排除节点）
     */
    @PreAuthorize("@ss.hasPermi('system:devices_group:list')")
    @GetMapping("/list/exclude/{groupId}")
    public AjaxResult excludeChild(@PathVariable(value = "groupId", required = false) Long groupId)
    {
        List<SysDevicesGroup> list = sysDevicesGroupService.selectSysDevicesGroupList(new SysDevicesGroup());
        list.removeIf(d -> d.getGroupId().intValue() == groupId || ArrayUtils.contains(StringUtils.split(d.getAncestors(), ","), groupId + ""));
        return success(list);
    }

    /**
     * 导出设备分组列表
     */
    @PreAuthorize("@ss.hasPermi('system:devices_group:export')")
    @Log(title = "设备分组", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysDevicesGroup sysDevicesGroup)
    {
        List<SysDevicesGroup> list = sysDevicesGroupService.selectSysDevicesGroupList(sysDevicesGroup);
        ExcelUtil<SysDevicesGroup> util = new ExcelUtil<SysDevicesGroup>(SysDevicesGroup.class);
        util.exportExcel(response, list, "设备分组数据");
    }

    /**
     * 获取设备分组详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:devices_group:query')")
    @GetMapping(value = "/{groupId}")
    public AjaxResult getInfo(@PathVariable("groupId") Long groupId)
    {
        return success(sysDevicesGroupService.selectSysDevicesGroupByGroupId(groupId));
    }

    /**
     * 新增设备分组
     */
    @PreAuthorize("@ss.hasPermi('system:devices_group:add')")
    @Log(title = "设备分组", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysDevicesGroup sysDevicesGroup)
    {
        return toAjax(sysDevicesGroupService.insertSysDevicesGroup(sysDevicesGroup));
    }

    /**
     * 修改设备分组
     */
    @PreAuthorize("@ss.hasPermi('system:devices_group:edit')")
    @Log(title = "设备分组", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysDevicesGroup sysDevicesGroup)
    {
        return toAjax(sysDevicesGroupService.updateSysDevicesGroup(sysDevicesGroup));
    }

    /**
     * 删除设备分组
     */
    @PreAuthorize("@ss.hasPermi('system:devices_group:remove')")
    @Log(title = "设备分组", businessType = BusinessType.DELETE)
	@DeleteMapping("/{groupIds}")
    public AjaxResult remove(@PathVariable Long[] groupIds)
    {
        return toAjax(sysDevicesGroupService.deleteSysDevicesGroupByGroupIds(groupIds));
    }
}
