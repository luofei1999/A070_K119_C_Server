package com.ruoyi.patient.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.SecurityUtils;
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
import com.ruoyi.patient.domain.DoctorPatient;
import com.ruoyi.patient.service.IDoctorPatientService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 患者列表Controller
 * 
 * @author 尹罗飞
 * @date 2025-05-07
 */
@RestController
@RequestMapping("/patient/doctor_patient")
public class DoctorPatientController extends BaseController
{
    @Autowired
    private IDoctorPatientService doctorPatientService;

    /**
     * 查询患者列表列表
     */
    @PreAuthorize("@ss.hasPermi('patient:doctor_patient:list')")
    @GetMapping("/list")
    public TableDataInfo list(DoctorPatient doctorPatient)
    {
        // 获取当前用户ID
        Long userId = SecurityUtils.getUserId();
        // 判断当前用户是否是管理员
        boolean isAdmin = SecurityUtils.isAdmin(userId);
        // 如果是管理员，则查询所有患者
        if (isAdmin) {
            // 设置查询条件
            doctorPatient.setDoctorid(null);
        }
        startPage();
        List<DoctorPatient> list = doctorPatientService.selectDoctorPatientList(doctorPatient);
        return getDataTable(list);
    }

    /**
     * 导出患者列表列表
     */
    @PreAuthorize("@ss.hasPermi('patient:doctor_patient:export')")
    @Log(title = "患者列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DoctorPatient doctorPatient)
    {
        List<DoctorPatient> list = doctorPatientService.selectDoctorPatientList(doctorPatient);
        ExcelUtil<DoctorPatient> util = new ExcelUtil<DoctorPatient>(DoctorPatient.class);
        util.exportExcel(response, list, "患者列表数据");
    }

    /**
     * 获取患者列表详细信息
     */
    @PreAuthorize("@ss.hasPermi('patient:doctor_patient:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(doctorPatientService.selectDoctorPatientById(id));
    }

    /**
     * 新增患者列表
     */
    @PreAuthorize("@ss.hasPermi('patient:doctor_patient:add')")
    @Log(title = "患者列表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DoctorPatient doctorPatient)
    {
        return toAjax(doctorPatientService.insertDoctorPatient(doctorPatient));
    }

    /**
     * 修改患者列表
     */
    @PreAuthorize("@ss.hasPermi('patient:doctor_patient:edit')")
    @Log(title = "患者列表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DoctorPatient doctorPatient)
    {
        return toAjax(doctorPatientService.updateDoctorPatient(doctorPatient));
    }

    /**
     * 删除患者列表
     */
    @PreAuthorize("@ss.hasPermi('patient:doctor_patient:remove')")
    @Log(title = "患者列表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(doctorPatientService.deleteDoctorPatientByIds(ids));
    }
}
