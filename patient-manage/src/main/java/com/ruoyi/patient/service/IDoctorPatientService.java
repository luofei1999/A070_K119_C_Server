package com.ruoyi.patient.service;

import java.util.List;
import com.ruoyi.patient.domain.DoctorPatient;

/**
 * 患者列表Service接口
 * 
 * @author 尹罗飞
 * @date 2025-05-07
 */
public interface IDoctorPatientService 
{
    /**
     * 查询患者列表
     * 
     * @param id 患者列表主键
     * @return 患者列表
     */
    public DoctorPatient selectDoctorPatientById(Long id);

    /**
     * 查询患者列表列表
     * 
     * @param doctorPatient 患者列表
     * @return 患者列表集合
     */
    public List<DoctorPatient> selectDoctorPatientList(DoctorPatient doctorPatient);

    /**
     * 新增患者列表
     * 
     * @param doctorPatient 患者列表
     * @return 结果
     */
    public int insertDoctorPatient(DoctorPatient doctorPatient);

    /**
     * 修改患者列表
     * 
     * @param doctorPatient 患者列表
     * @return 结果
     */
    public int updateDoctorPatient(DoctorPatient doctorPatient);

    /**
     * 批量删除患者列表
     * 
     * @param ids 需要删除的患者列表主键集合
     * @return 结果
     */
    public int deleteDoctorPatientByIds(Long[] ids);

    /**
     * 删除患者列表信息
     * 
     * @param id 患者列表主键
     * @return 结果
     */
    public int deleteDoctorPatientById(Long id);
}
