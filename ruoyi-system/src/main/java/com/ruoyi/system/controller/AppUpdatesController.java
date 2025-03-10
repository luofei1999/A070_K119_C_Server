package com.ruoyi.system.controller;

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
import com.ruoyi.system.domain.AppUpdates;
import com.ruoyi.system.service.IAppUpdatesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 应用更新Controller
 * 
 * @author 尹罗飞
 * @date 2025-03-10
 */
@RestController
@RequestMapping("/system/updates")
public class AppUpdatesController extends BaseController
{
    @Autowired
    private IAppUpdatesService appUpdatesService;

    /**
     * 查询应用更新列表
     */
    @PreAuthorize("@ss.hasPermi('system:updates:list')")
    @GetMapping("/list")
    public TableDataInfo list(AppUpdates appUpdates)
    {
        startPage();
        List<AppUpdates> list = appUpdatesService.selectAppUpdatesList(appUpdates);
        return getDataTable(list);
    }

    /**
     * 查询应用更新列表
     */
    @Anonymous
    @GetMapping("/update")
    public AppUpdates update(AppUpdates appUpdate)
    {

        return appUpdatesService.selectAppLatestUpdate(appUpdate);
    }

    /**
     * 导出应用更新列表
     */
    @PreAuthorize("@ss.hasPermi('system:updates:export')")
    @Log(title = "应用更新", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppUpdates appUpdates)
    {
        List<AppUpdates> list = appUpdatesService.selectAppUpdatesList(appUpdates);
        ExcelUtil<AppUpdates> util = new ExcelUtil<AppUpdates>(AppUpdates.class);
        util.exportExcel(response, list, "应用更新数据");
    }

    /**
     * 获取应用更新详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:updates:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(appUpdatesService.selectAppUpdatesById(id));
    }

    /**
     * 新增应用更新
     */
    @PreAuthorize("@ss.hasPermi('system:updates:add')")
    @Log(title = "应用更新", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppUpdates appUpdates)
    {
        return toAjax(appUpdatesService.insertAppUpdates(appUpdates));
    }

    /**
     * 修改应用更新
     */
    @PreAuthorize("@ss.hasPermi('system:updates:edit')")
    @Log(title = "应用更新", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppUpdates appUpdates)
    {
        return toAjax(appUpdatesService.updateAppUpdates(appUpdates));
    }

    /**
     * 删除应用更新
     */
    @PreAuthorize("@ss.hasPermi('system:updates:remove')")
    @Log(title = "应用更新", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(appUpdatesService.deleteAppUpdatesByIds(ids));
    }
}
