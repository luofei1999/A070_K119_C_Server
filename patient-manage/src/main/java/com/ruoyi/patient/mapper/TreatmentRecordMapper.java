package com.ruoyi.patient.mapper;

import java.util.List;
import com.ruoyi.patient.domain.TreatmentRecord;

/**
 * 治疗记录Mapper接口
 * 
 * @author 尹罗飞
 * @date 2025-02-26
 */
public interface TreatmentRecordMapper 
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

    public List<TreatmentRecord> selectTreatmentRecordListNoUser(TreatmentRecord treatmentRecord);



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
     * 删除治疗记录
     * 
     * @param id 治疗记录主键
     * @return 结果
     */
    public int deleteTreatmentRecordById(Long id);

    /**
     * 批量删除治疗记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTreatmentRecordByIds(Long[] ids);

    /**
     * 查询治疗记录详情，包含图片信息
     * @param id 治疗记录主键
     * @return 治疗记录详情
     */
    TreatmentRecord selectTreatmentRecordWithImages(Long id);  // <-- 添加这个方法
}
