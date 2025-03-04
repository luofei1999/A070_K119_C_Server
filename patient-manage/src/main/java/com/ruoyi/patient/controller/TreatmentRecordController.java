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
import com.ruoyi.patient.domain.TreatmentRecord;
import com.ruoyi.patient.service.ITreatmentRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 治疗记录Controller
 * 
 * @author 尹罗飞
 * @date 2025-02-26
 */
@RestController
@RequestMapping("/patient/treatment_record")
public class TreatmentRecordController extends BaseController
{
    @Autowired
    private ITreatmentRecordService treatmentRecordService;

    /**
     * 查询治疗记录列表
     */
    @PreAuthorize("@ss.hasPermi('patient:treatment_record:list')")
    @GetMapping("/list")
    @DataScope(userAlias = "u")
    public TableDataInfo list(TreatmentRecord treatmentRecord)
    {
        startPage();
        List<TreatmentRecord> list = treatmentRecordService.selectTreatmentRecordList(treatmentRecord);
        return getDataTable(list);
    }

    /**
     * 导出治疗记录列表
     */
    @PreAuthorize("@ss.hasPermi('patient:treatment_record:export')")
    @Log(title = "治疗记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TreatmentRecord treatmentRecord)
    {
        List<TreatmentRecord> list = treatmentRecordService.selectTreatmentRecordList(treatmentRecord);
        ExcelUtil<TreatmentRecord> util = new ExcelUtil<TreatmentRecord>(TreatmentRecord.class);
        util.exportExcel(response, list, "治疗记录数据");
    }

    /**
     * 获取治疗记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('patient:treatment_record:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(treatmentRecordService.selectTreatmentRecordById(id));
    }

    /**
     * 新增治疗记录
     */
    @PreAuthorize("@ss.hasPermi('patient:treatment_record:add')")
    @Log(title = "治疗记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TreatmentRecord treatmentRecord)
    {
        return toAjax(treatmentRecordService.insertTreatmentRecord(treatmentRecord));
    }

    /**
     * 修改治疗记录
     */
    @PreAuthorize("@ss.hasPermi('patient:treatment_record:edit')")
    @Log(title = "治疗记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TreatmentRecord treatmentRecord)
    {
        return toAjax(treatmentRecordService.updateTreatmentRecord(treatmentRecord));
    }

    /**
     * 删除治疗记录
     */
    @PreAuthorize("@ss.hasPermi('patient:treatment_record:remove')")
    @Log(title = "治疗记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(treatmentRecordService.deleteTreatmentRecordByIds(ids));
    }
}
