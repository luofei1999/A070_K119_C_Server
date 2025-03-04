package com.ruoyi.patient.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.annotation.DataScope;
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
import com.ruoyi.patient.domain.OximeterData;
import com.ruoyi.patient.service.IOximeterDataService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 血氧仪Controller
 * 
 * @author 尹罗飞
 * @date 2025-02-26
 */
@RestController
@RequestMapping("/patient/oximeter")
public class OximeterDataController extends BaseController
{
    @Autowired
    private IOximeterDataService oximeterDataService;

    /**
     * 查询血氧仪列表
     */
    @PreAuthorize("@ss.hasPermi('patient:oximeter:list')")
    @GetMapping("/list")
    @DataScope(userAlias = "u")
    public TableDataInfo list(OximeterData oximeterData)
    {
        startPage();
        List<OximeterData> list = oximeterDataService.selectOximeterDataList(oximeterData);
        return getDataTable(list);
    }

    /**
     * 导出血氧仪列表
     */
    @PreAuthorize("@ss.hasPermi('patient:oximeter:export')")
    @Log(title = "血氧仪", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OximeterData oximeterData)
    {
        List<OximeterData> list = oximeterDataService.selectOximeterDataList(oximeterData);
        ExcelUtil<OximeterData> util = new ExcelUtil<OximeterData>(OximeterData.class);
        util.exportExcel(response, list, "血氧仪数据");
    }

    /**
     * 获取血氧仪详细信息
     */
    @PreAuthorize("@ss.hasPermi('patient:oximeter:query')")
    @GetMapping(value = "/{oximeterId}")
    public AjaxResult getInfo(@PathVariable("oximeterId") Long oximeterId)
    {
        return success(oximeterDataService.selectOximeterDataByOximeterId(oximeterId));
    }

    /**
     * 新增血氧仪
     */
    @PreAuthorize("@ss.hasPermi('patient:oximeter:add')")
    @Log(title = "血氧仪", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OximeterData oximeterData)
    {
        return toAjax(oximeterDataService.insertOximeterData(oximeterData));
    }

    /**
     * 修改血氧仪
     */
    @PreAuthorize("@ss.hasPermi('patient:oximeter:edit')")
    @Log(title = "血氧仪", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OximeterData oximeterData)
    {
        return toAjax(oximeterDataService.updateOximeterData(oximeterData));
    }

    /**
     * 删除血氧仪
     */
    @PreAuthorize("@ss.hasPermi('patient:oximeter:remove')")
    @Log(title = "血氧仪", businessType = BusinessType.DELETE)
	@DeleteMapping("/{oximeterIds}")
    public AjaxResult remove(@PathVariable Long[] oximeterIds)
    {
        return toAjax(oximeterDataService.deleteOximeterDataByOximeterIds(oximeterIds));
    }
}
