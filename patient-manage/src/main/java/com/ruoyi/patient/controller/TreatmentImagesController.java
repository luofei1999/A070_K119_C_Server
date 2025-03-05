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
import com.ruoyi.patient.domain.TreatmentImages;
import com.ruoyi.patient.service.ITreatmentImagesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 治疗图片Controller
 * 
 * @author 尹罗飞
 * @date 2025-03-05
 */
@RestController
@RequestMapping("/patient/treatment_images")
public class TreatmentImagesController extends BaseController
{
    @Autowired
    private ITreatmentImagesService treatmentImagesService;

    /**
     * 查询治疗图片列表
     */
    @PreAuthorize("@ss.hasPermi('patient:treatment_images:list')")
    @GetMapping("/list")
    @DataScope(userAlias = "u")
    public TableDataInfo list(TreatmentImages treatmentImages)
    {
        startPage();
        List<TreatmentImages> list = treatmentImagesService.selectTreatmentImagesList(treatmentImages);
        return getDataTable(list);
    }

    /**
     * 导出治疗图片列表
     */
    @PreAuthorize("@ss.hasPermi('patient:treatment_images:export')")
    @Log(title = "治疗图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TreatmentImages treatmentImages)
    {
        List<TreatmentImages> list = treatmentImagesService.selectTreatmentImagesList(treatmentImages);
        ExcelUtil<TreatmentImages> util = new ExcelUtil<TreatmentImages>(TreatmentImages.class);
        util.exportExcel(response, list, "治疗图片数据");
    }

    /**
     * 获取治疗图片详细信息
     */
    @PreAuthorize("@ss.hasPermi('patient:treatment_images:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(treatmentImagesService.selectTreatmentImagesById(id));
    }

    /**
     * 新增治疗图片
     */
    @PreAuthorize("@ss.hasPermi('patient:treatment_images:add')")
    @Log(title = "治疗图片", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TreatmentImages treatmentImages)
    {
        return toAjax(treatmentImagesService.insertTreatmentImages(treatmentImages));
    }

    /**
     * 修改治疗图片
     */
    @PreAuthorize("@ss.hasPermi('patient:treatment_images:edit')")
    @Log(title = "治疗图片", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TreatmentImages treatmentImages)
    {
        return toAjax(treatmentImagesService.updateTreatmentImages(treatmentImages));
    }

    /**
     * 删除治疗图片
     */
    @PreAuthorize("@ss.hasPermi('patient:treatment_images:remove')")
    @Log(title = "治疗图片", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(treatmentImagesService.deleteTreatmentImagesByIds(ids));
    }
}
