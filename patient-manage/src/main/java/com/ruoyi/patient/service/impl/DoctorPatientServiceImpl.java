package com.ruoyi.patient.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.patient.mapper.DoctorPatientMapper;
import com.ruoyi.patient.domain.DoctorPatient;
import com.ruoyi.patient.service.IDoctorPatientService;

/**
 * 患者列表Service业务层处理
 * 
 * @author 尹罗飞
 * @date 2025-05-07
 */
@Service
public class DoctorPatientServiceImpl implements IDoctorPatientService 
{
    @Autowired
    private DoctorPatientMapper doctorPatientMapper;

    /**
     * 查询患者列表
     * 
     * @param id 患者列表主键
     * @return 患者列表
     */
    @Override
    public DoctorPatient selectDoctorPatientById(Long id)
    {
        return doctorPatientMapper.selectDoctorPatientById(id);
    }

    /**
     * 查询患者列表列表
     * 
     * @param doctorPatient 患者列表
     * @return 患者列表
     */
    @Override
    public List<DoctorPatient> selectDoctorPatientList(DoctorPatient doctorPatient)
    {
        return doctorPatientMapper.selectDoctorPatientList(doctorPatient);
    }

    /**
     * 新增患者列表
     * 
     * @param doctorPatient 患者列表
     * @return 结果
     */
    @Override
    public int insertDoctorPatient(DoctorPatient doctorPatient)
    {
        return doctorPatientMapper.insertDoctorPatient(doctorPatient);
    }

    /**
     * 修改患者列表
     * 
     * @param doctorPatient 患者列表
     * @return 结果
     */
    @Override
    public int updateDoctorPatient(DoctorPatient doctorPatient)
    {
        return doctorPatientMapper.updateDoctorPatient(doctorPatient);
    }

    /**
     * 批量删除患者列表
     * 
     * @param ids 需要删除的患者列表主键
     * @return 结果
     */
    @Override
    public int deleteDoctorPatientByIds(Long[] ids)
    {
        return doctorPatientMapper.deleteDoctorPatientByIds(ids);
    }

    /**
     * 删除患者列表信息
     * 
     * @param id 患者列表主键
     * @return 结果
     */
    @Override
    public int deleteDoctorPatientById(Long id)
    {
        return doctorPatientMapper.deleteDoctorPatientById(id);
    }
}
