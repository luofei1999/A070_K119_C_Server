package com.ruoyi.patient.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.framework.config.ServerConfig;
import com.ruoyi.patient.domain.TreatmentImages;
import com.ruoyi.patient.service.ITreatmentImagesService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.patient.domain.TreatmentRecord;
import com.ruoyi.patient.service.ITreatmentRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

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
    @Autowired
    private ITreatmentImagesService treatmentImagesService; // 自动注入
    @Autowired
    private ServerConfig serverConfig;
    private static final String FILE_DELIMETER = ",";

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

    @PreAuthorize("@ss.hasPermi('patient:treatment_record:list')")
    @GetMapping("/recordDetail")
    @DataScope(userAlias = "u")
    public TableDataInfo detail(TreatmentRecord treatmentRecord)
    {
        startPage();
        List<TreatmentRecord> list = treatmentRecordService.selectTreatmentRecordList(treatmentRecord);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('patient:treatment_record:query')")
    @GetMapping(value = "/detail/{id}")
    public AjaxResult getRecordDetail(@PathVariable("id") Long id) {
        return success(treatmentRecordService.selectTreatmentRecordWithImages(id));
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
       return success(treatmentRecordService.insertTreatmentRecord(treatmentRecord));
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

    /**
     * 单张治疗图片上传
     */
    @PostMapping("/uploadImage")
    public AjaxResult uploadFileImg(@RequestParam("treatmentId") String treatmentId, @RequestParam("file") MultipartFile file, @RequestParam("isTreatmentAfter") String isTreatmentAfter) {
        try
        {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadImagePath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file, treatmentId);
            String url = serverConfig.getUrl() + fileName;

            String newName = FileUtils.getName(fileName);

            // 构造治疗图片实体对象
            TreatmentImages treatmentImages = new TreatmentImages();
            treatmentImages.setTreatmentId(Long.parseLong(treatmentId)); // 注意类型转换
            treatmentImages.setUserId(SecurityUtils.getUserId());
            treatmentImages.setUserName(SecurityUtils.getUsername());
            treatmentImages.setName(newName); // 保存文件名
            treatmentImages.setPath(fileName);    // 保存文件存储路径
            treatmentImages.setUrl(url);     // 保存访问地址
            treatmentImages.setIsTreatmentAfter(isTreatmentAfter);     // 图片标识
            // 调用服务层插入图片数据
            treatmentImagesService.insertTreatmentImages(treatmentImages);

            AjaxResult ajax = AjaxResult.success();
            ajax.put("url", url);
            ajax.put("fileName", fileName);
            ajax.put("newFileName", newName);
            ajax.put("originalFilename", file.getOriginalFilename());
            ajax.put("treatment_id", treatmentId);

            // 获取当前的用户名称
            ajax.put("user_id", SecurityUtils.getUserId());
            ajax.put("user_name", SecurityUtils.getUsername());
            return ajax;
        }
        catch (Exception e)
        {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 多张治疗前图片上传
     */
    @PostMapping("/uploadTreatmentBeforeImages")
    public AjaxResult uploadTreatmentBeforeImages(@RequestParam("treatmentId") String treatmentId,
                                                  @RequestPart("files") List<MultipartFile> files) {
        try {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadImagePath();
            List<String> urls = new ArrayList<>();
            List<String> fileNames = new ArrayList<>();
            List<String> newFileNames = new ArrayList<>();
            List<String> originalFilenames = new ArrayList<>();

            for (MultipartFile file : files) {
                // 上传并返回新文件名称
                String fileName = FileUploadUtils.upload(filePath, file, treatmentId);
                String url = serverConfig.getUrl() + fileName;
                String newName = FileUtils.getName(fileName);

                // 构造治疗图片实体对象
                TreatmentImages treatmentImages = new TreatmentImages();
                treatmentImages.setTreatmentId(Long.parseLong(treatmentId)); // 注意类型转换
                treatmentImages.setUserId(SecurityUtils.getUserId());
                treatmentImages.setUserName(SecurityUtils.getUsername());
                treatmentImages.setName(newName); // 保存文件名
                treatmentImages.setPath(fileName);    // 保存文件存储路径
                treatmentImages.setUrl(url);     // 保存访问地址
                treatmentImages.setIsTreatmentAfter("0");     // 治疗前图片标识

                // 调用服务层插入图片数据
                treatmentImagesService.insertTreatmentImages(treatmentImages);

                // 收集每个文件的信息
                urls.add(url);
                fileNames.add(fileName);
                newFileNames.add(newName);
                originalFilenames.add(file.getOriginalFilename());
            }

            AjaxResult ajax = AjaxResult.success();
            ajax.put("urls", StringUtils.join(urls, FILE_DELIMETER));
            ajax.put("fileNames", StringUtils.join(fileNames, FILE_DELIMETER));
            ajax.put("newFileNames", StringUtils.join(newFileNames, FILE_DELIMETER));
            ajax.put("originalFilenames", StringUtils.join(originalFilenames, FILE_DELIMETER));
            ajax.put("treatment_id", treatmentId);

            // 获取当前的用户名称
            ajax.put("user_id", SecurityUtils.getUserId());
            ajax.put("user_name", SecurityUtils.getUsername());
            return ajax;
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 多张治疗后图片上传
     */
    @PostMapping("/uploadTreatmentAfterImages")
    public AjaxResult uploadTreatmentAfterImages(@RequestParam("treatmentId") String treatmentId,
                                                 @RequestPart("files") List<MultipartFile> files) {
        try {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadImagePath();
            List<String> urls = new ArrayList<>();
            List<String> fileNames = new ArrayList<>();
            List<String> newFileNames = new ArrayList<>();
            List<String> originalFilenames = new ArrayList<>();

            for (MultipartFile file : files) {
                // 上传并返回新文件名称
                String fileName = FileUploadUtils.upload(filePath, file, treatmentId);
                String url = serverConfig.getUrl() + fileName;
                String newName = FileUtils.getName(fileName);

                // 构造治疗图片实体对象
                TreatmentImages treatmentImages = new TreatmentImages();
                treatmentImages.setTreatmentId(Long.parseLong(treatmentId)); // 注意类型转换
                treatmentImages.setUserId(SecurityUtils.getUserId());
                treatmentImages.setUserName(SecurityUtils.getUsername());
                treatmentImages.setName(newName); // 保存文件名
                treatmentImages.setPath(fileName);    // 保存文件存储路径
                treatmentImages.setUrl(url);     // 保存访问地址
                treatmentImages.setIsTreatmentAfter("1");     // 治疗后图片标识

                // 调用服务层插入图片数据
                treatmentImagesService.insertTreatmentImages(treatmentImages);

                // 收集每个文件的信息
                urls.add(url);
                fileNames.add(fileName);
                newFileNames.add(newName);
                originalFilenames.add(file.getOriginalFilename());
            }

            AjaxResult ajax = AjaxResult.success();
            ajax.put("urls", StringUtils.join(urls, FILE_DELIMETER));
            ajax.put("fileNames", StringUtils.join(fileNames, FILE_DELIMETER));
            ajax.put("newFileNames", StringUtils.join(newFileNames, FILE_DELIMETER));
            ajax.put("originalFilenames", StringUtils.join(originalFilenames, FILE_DELIMETER));
            ajax.put("treatment_id", treatmentId);

            // 获取当前的用户名称
            ajax.put("user_id", SecurityUtils.getUserId());
            ajax.put("user_name", SecurityUtils.getUsername());
            return ajax;
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

}
