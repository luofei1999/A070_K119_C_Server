package com.ruoyi.patient.service.impl;

import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.patient.mapper.TreatmentRecordMapper;
import com.ruoyi.patient.domain.TreatmentRecord;
import com.ruoyi.patient.service.ITreatmentRecordService;

/**
 * 治疗记录Service业务层处理
 * 
 * @author 尹罗飞
 * @date 2025-02-26
 */
@Service
public class TreatmentRecordServiceImpl implements ITreatmentRecordService 
{
    @Autowired
    private TreatmentRecordMapper treatmentRecordMapper;

    /**
     * 查询治疗记录
     * 
     * @param id 治疗记录主键
     * @return 治疗记录
     */
    @Override
    public TreatmentRecord selectTreatmentRecordById(Long id)
    {
        return treatmentRecordMapper.selectTreatmentRecordById(id);
    }

    /**
     * 查询治疗记录列表
     * 
     * @param treatmentRecord 治疗记录
     * @return 治疗记录
     */
    @Override
    public List<TreatmentRecord> selectTreatmentRecordList(TreatmentRecord treatmentRecord)
    {
        return treatmentRecordMapper.selectTreatmentRecordList(treatmentRecord);
    }

    /**
     * 新增治疗记录
     * 
     * @param treatmentRecord 治疗记录
     * @return 结果
     */
    @Override
    public long insertTreatmentRecord(TreatmentRecord treatmentRecord)
    {
        // 使用当前登录用户 ID
        if (treatmentRecord.getUserId() == 0) {
            treatmentRecord.setUserId(SecurityUtils.getUserId());
        }
        int result = treatmentRecordMapper.insertTreatmentRecord(treatmentRecord);
        return result > 0 ? treatmentRecord.getId() : result;
    }

    /**
     * 修改治疗记录
     * 
     * @param treatmentRecord 治疗记录
     * @return 结果
     */
    @Override
    public int updateTreatmentRecord(TreatmentRecord treatmentRecord)
    {
        return treatmentRecordMapper.updateTreatmentRecord(treatmentRecord);
    }

    /**
     * 批量删除治疗记录
     * 
     * @param ids 需要删除的治疗记录主键
     * @return 结果
     */
    @Override
    public int deleteTreatmentRecordByIds(Long[] ids)
    {
        return treatmentRecordMapper.deleteTreatmentRecordByIds(ids);
    }

    /**
     * 删除治疗记录信息
     * 
     * @param id 治疗记录主键
     * @return 结果
     */
    @Override
    public int deleteTreatmentRecordById(Long id)
    {
        return treatmentRecordMapper.deleteTreatmentRecordById(id);
    }

    @Override
    public TreatmentRecord selectTreatmentRecordWithImages(Long id) {
        return treatmentRecordMapper.selectTreatmentRecordWithImages(id);
    }


}
