package com.ruoyi.patient.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.patient.mapper.TreatmentImagesMapper;
import com.ruoyi.patient.domain.TreatmentImages;
import com.ruoyi.patient.service.ITreatmentImagesService;

/**
 * 治疗图片Service业务层处理
 * 
 * @author 尹罗飞
 * @date 2025-03-05
 */
@Service
public class TreatmentImagesServiceImpl implements ITreatmentImagesService 
{
    @Autowired
    private TreatmentImagesMapper treatmentImagesMapper;

    /**
     * 查询治疗图片
     * 
     * @param id 治疗图片主键
     * @return 治疗图片
     */
    @Override
    public TreatmentImages selectTreatmentImagesById(Long id)
    {
        return treatmentImagesMapper.selectTreatmentImagesById(id);
    }

    /**
     * 查询治疗图片列表
     * 
     * @param treatmentImages 治疗图片
     * @return 治疗图片
     */
    @Override
    public List<TreatmentImages> selectTreatmentImagesList(TreatmentImages treatmentImages)
    {
        return treatmentImagesMapper.selectTreatmentImagesList(treatmentImages);
    }

    @Override
    public List<TreatmentImages> selectTreatmentImagesListNoUser(TreatmentImages treatmentImages)
    {
        return treatmentImagesMapper.selectTreatmentImagesListNoUser(treatmentImages);
    }



    /**
     * 新增治疗图片
     * 
     * @param treatmentImages 治疗图片
     * @return 结果
     */
    @Override
    public int insertTreatmentImages(TreatmentImages treatmentImages)
    {
        treatmentImages.setCreateTime(DateUtils.getNowDate());
        return treatmentImagesMapper.insertTreatmentImages(treatmentImages);
    }

    /**
     * 修改治疗图片
     * 
     * @param treatmentImages 治疗图片
     * @return 结果
     */
    @Override
    public int updateTreatmentImages(TreatmentImages treatmentImages)
    {
        return treatmentImagesMapper.updateTreatmentImages(treatmentImages);
    }

    /**
     * 批量删除治疗图片
     * 
     * @param ids 需要删除的治疗图片主键
     * @return 结果
     */
    @Override
    public int deleteTreatmentImagesByIds(Long[] ids)
    {
        return treatmentImagesMapper.deleteTreatmentImagesByIds(ids);
    }

    /**
     * 删除治疗图片信息
     * 
     * @param id 治疗图片主键
     * @return 结果
     */
    @Override
    public int deleteTreatmentImagesById(Long id)
    {
        return treatmentImagesMapper.deleteTreatmentImagesById(id);
    }
}
