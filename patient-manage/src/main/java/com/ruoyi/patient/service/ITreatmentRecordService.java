package com.ruoyi.patient.service;

import java.util.List;
import com.ruoyi.patient.domain.TreatmentRecord;

/**
 * 治疗记录Service接口
 * 
 * @author 尹罗飞
 * @date 2025-02-26
 */
public interface ITreatmentRecordService 
{
    /**
     * 查询治疗记录
     * 
     * @param id 治疗记录主键
     * @return 治疗记录
     */
    public TreatmentRecord selectTreatmentRecordById(Long id);

    /**
     * 查询治疗记录列表
     * 
     * @param treatmentRecord 治疗记录
     * @return 治疗记录集合
     */
    public List<TreatmentRecord> selectTreatmentRecordList(TreatmentRecord treatmentRecord);

    /**
     * 新增治疗记录
     * 
     * @param treatmentRecord 治疗记录
     * @return 结果
     */
    public int insertTreatmentRecord(TreatmentRecord treatmentRecord);

    /**
     * 修改治疗记录
     * 
     * @param treatmentRecord 治疗记录
     * @return 结果
     */
    public int updateTreatmentRecord(TreatmentRecord treatmentRecord);

    /**
     * 批量删除治疗记录
     * 
     * @param ids 需要删除的治疗记录主键集合
     * @return 结果
     */
    public int deleteTreatmentRecordByIds(Long[] ids);

    /**
     * 删除治疗记录信息
     * 
     * @param id 治疗记录主键
     * @return 结果
     */
    public int deleteTreatmentRecordById(Long id);

    TreatmentRecord selectTreatmentRecordWithImages(Long id);


}
