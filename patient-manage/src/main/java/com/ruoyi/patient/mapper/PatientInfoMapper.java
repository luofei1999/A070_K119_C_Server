package com.ruoyi.patient.mapper;

import java.util.List;
import com.ruoyi.patient.domain.PatientInfo;

/**
 * 患者资料Mapper接口
 * 
 * @author 尹罗飞
 * @date 2025-02-26
 */
public interface PatientInfoMapper 
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
     * 删除患者资料
     * 
     * @param patientId 患者资料主键
     * @return 结果
     */
    public int deletePatientInfoByPatientId(Long patientId);

    /**
     * 批量删除患者资料
     * 
     * @param patientIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePatientInfoByPatientIds(Long[] patientIds);
}
