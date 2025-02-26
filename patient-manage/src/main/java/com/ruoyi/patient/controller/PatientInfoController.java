package com.ruoyi.patient.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.patient.domain.PatientInfo;
import com.ruoyi.patient.service.IPatientInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 患者资料Controller
 * 
 * @author 尹罗飞
 * @date 2025-02-26
 */
@RestController
@RequestMapping("/patient/info")
public class PatientInfoController extends BaseController
{
    @Autowired
    private IPatientInfoService patientInfoService;

    /**
     * 查询患者资料列表
     */
    @PreAuthorize("@ss.hasPermi('patient:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(PatientInfo patientInfo)
    {
        startPage();
        List<PatientInfo> list = patientInfoService.selectPatientInfoList(patientInfo);
        return getDataTable(list);
    }

    /**
     * 导出患者资料列表
     */
    @PreAuthorize("@ss.hasPermi('patient:info:export')")
    @Log(title = "患者资料", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PatientInfo patientInfo)
    {
        List<PatientInfo> list = patientInfoService.selectPatientInfoList(patientInfo);
        ExcelUtil<PatientInfo> util = new ExcelUtil<PatientInfo>(PatientInfo.class);
        util.exportExcel(response, list, "患者资料数据");
    }

    /**
     * 获取患者资料详细信息
     */
    @PreAuthorize("@ss.hasPermi('patient:info:query')")
    @GetMapping(value = "/{patientId}")
    public AjaxResult getInfo(@PathVariable("patientId") Long patientId)
    {
        return success(patientInfoService.selectPatientInfoByPatientId(patientId));
    }

    /**
     * 新增患者资料
     */
    @PreAuthorize("@ss.hasPermi('patient:info:add')")
    @Log(title = "患者资料", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PatientInfo patientInfo)
    {
        return toAjax(patientInfoService.insertPatientInfo(patientInfo));
    }

    /**
     * 修改患者资料
     */
    @PreAuthorize("@ss.hasPermi('patient:info:edit')")
    @Log(title = "患者资料", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PatientInfo patientInfo)
    {
        return toAjax(patientInfoService.updatePatientInfo(patientInfo));
    }

    /**
     * 删除患者资料
     */
    @PreAuthorize("@ss.hasPermi('patient:info:remove')")
    @Log(title = "患者资料", businessType = BusinessType.DELETE)
	@DeleteMapping("/{patientIds}")
    public AjaxResult remove(@PathVariable Long[] patientIds)
    {
        return toAjax(patientInfoService.deletePatientInfoByPatientIds(patientIds));
    }
}
