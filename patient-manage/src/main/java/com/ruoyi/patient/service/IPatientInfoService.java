package com.ruoyi.patient.service;

import java.util.List;
import com.ruoyi.patient.domain.PatientInfo;

/**
 * 患者资料Service接口
 * 
 * @author 尹罗飞
 * @date 2025-02-25
 */
public interface IPatientInfoService 
{
    /**
     * 查询患者资料
     * 
     * @param patientId 患者资料主键
     * @return 患者资料
     */
    public PatientInfo selectPatientInfoByPatientId(Long patientId);

    /**
     * 查询患者资料列表
     * 
     * @param patientInfo 患者资料
     * @return 患者资料集合
     */
    public List<PatientInfo> selectPatientInfoList(PatientInfo patientInfo);

    /**
     * 新增患者资料
     * 
     * @param patientInfo 患者资料
     * @return 结果
     */
    public int insertPatientInfo(PatientInfo patientInfo);

    /**
     * 修改患者资料
     * 
     * @param patientInfo 患者资料
     * @return 结果
     */
    public int updatePatientInfo(PatientInfo patientInfo);

    /**
     * 批量删除患者资料
     * 
     * @param patientIds 需要删除的患者资料主键集合
     * @return 结果
     */
    public int deletePatientInfoByPatientIds(Long[] patientIds);

    /**
     * 删除患者资料信息
     * 
     * @param patientId 患者资料主键
     * @return 结果
     */
    public int deletePatientInfoByPatientId(Long patientId);
}
