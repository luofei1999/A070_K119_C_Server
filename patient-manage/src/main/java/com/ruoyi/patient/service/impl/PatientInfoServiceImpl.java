package com.ruoyi.patient.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.patient.mapper.PatientInfoMapper;
import com.ruoyi.patient.domain.PatientInfo;
import com.ruoyi.patient.service.IPatientInfoService;

/**
 * 患者资料Service业务层处理
 * 
 * @author 尹罗飞
 * @date 2025-02-25
 */
@Service
public class PatientInfoServiceImpl implements IPatientInfoService 
{
    @Autowired
    private PatientInfoMapper patientInfoMapper;

    /**
     * 查询患者资料
     * 
     * @param patientId 患者资料主键
     * @return 患者资料
     */
    @Override
    public PatientInfo selectPatientInfoByPatientId(Long patientId)
    {
        return patientInfoMapper.selectPatientInfoByPatientId(patientId);
    }

    /**
     * 查询患者资料列表
     * 
     * @param patientInfo 患者资料
     * @return 患者资料
     */
    @Override
    public List<PatientInfo> selectPatientInfoList(PatientInfo patientInfo)
    {
        return patientInfoMapper.selectPatientInfoList(patientInfo);
    }

    /**
     * 新增患者资料
     * 
     * @param patientInfo 患者资料
     * @return 结果
     */
    @Override
    public int insertPatientInfo(PatientInfo patientInfo)
    {
        return patientInfoMapper.insertPatientInfo(patientInfo);
    }

    /**
     * 修改患者资料
     * 
     * @param patientInfo 患者资料
     * @return 结果
     */
    @Override
    public int updatePatientInfo(PatientInfo patientInfo)
    {
        return patientInfoMapper.updatePatientInfo(patientInfo);
    }

    /**
     * 批量删除患者资料
     * 
     * @param patientIds 需要删除的患者资料主键
     * @return 结果
     */
    @Override
    public int deletePatientInfoByPatientIds(Long[] patientIds)
    {
        return patientInfoMapper.deletePatientInfoByPatientIds(patientIds);
    }

    /**
     * 删除患者资料信息
     * 
     * @param patientId 患者资料主键
     * @return 结果
     */
    @Override
    public int deletePatientInfoByPatientId(Long patientId)
    {
        return patientInfoMapper.deletePatientInfoByPatientId(patientId);
    }
}
