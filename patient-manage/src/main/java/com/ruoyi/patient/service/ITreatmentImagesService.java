package com.ruoyi.patient.service;

import java.util.List;
import com.ruoyi.patient.domain.TreatmentImages;

/**
 * 治疗图片Service接口
 * 
 * @author 尹罗飞
 * @date 2025-03-05
 */
public interface ITreatmentImagesService 
{
    /**
     * 查询治疗图片
     * 
     * @param id 治疗图片主键
     * @return 治疗图片
     */
    public TreatmentImages selectTreatmentImagesById(Long id);

    /**
     * 查询治疗图片列表
     * 
     * @param treatmentImages 治疗图片
     * @return 治疗图片集合
     */
    public List<TreatmentImages> selectTreatmentImagesList(TreatmentImages treatmentImages);
    public List<TreatmentImages> selectTreatmentImagesListNoUser(TreatmentImages treatmentImages);


    /**
     * 新增治疗图片
     * 
     * @param treatmentImages 治疗图片
     * @return 结果
     */
    public int insertTreatmentImages(TreatmentImages treatmentImages);

    /**
     * 修改治疗图片
     * 
     * @param treatmentImages 治疗图片
     * @return 结果
     */
    public int updateTreatmentImages(TreatmentImages treatmentImages);

    /**
     * 批量删除治疗图片
     * 
     * @param ids 需要删除的治疗图片主键集合
     * @return 结果
     */
    public int deleteTreatmentImagesByIds(Long[] ids);

    /**
     * 删除治疗图片信息
     * 
     * @param id 治疗图片主键
     * @return 结果
     */
    public int deleteTreatmentImagesById(Long id);
}
