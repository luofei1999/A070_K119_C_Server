package com.ruoyi.patient.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.patient.mapper.OximeterDataMapper;
import com.ruoyi.patient.domain.OximeterData;
import com.ruoyi.patient.service.IOximeterDataService;

/**
 * 血氧仪Service业务层处理
 * 
 * @author 尹罗飞
 * @date 2025-02-26
 */
@Service
public class OximeterDataServiceImpl implements IOximeterDataService 
{
    @Autowired
    private OximeterDataMapper oximeterDataMapper;

    /**
     * 查询血氧仪
     * 
     * @param oximeterId 血氧仪主键
     * @return 血氧仪
     */
    @Override
    public OximeterData selectOximeterDataByOximeterId(Long oximeterId)
    {
        return oximeterDataMapper.selectOximeterDataByOximeterId(oximeterId);
    }

    /**
     * 查询血氧仪列表
     * 
     * @param oximeterData 血氧仪
     * @return 血氧仪
     */
    @Override
    public List<OximeterData> selectOximeterDataList(OximeterData oximeterData)
    {
        return oximeterDataMapper.selectOximeterDataList(oximeterData);
    }

    /**
     * 新增血氧仪
     * 
     * @param oximeterData 血氧仪
     * @return 结果
     */
    @Override
    public int insertOximeterData(OximeterData oximeterData)
    {
        oximeterData.setCreateTime(DateUtils.getNowDate());
        return oximeterDataMapper.insertOximeterData(oximeterData);
    }

    /**
     * 修改血氧仪
     * 
     * @param oximeterData 血氧仪
     * @return 结果
     */
    @Override
    public int updateOximeterData(OximeterData oximeterData)
    {
        return oximeterDataMapper.updateOximeterData(oximeterData);
    }

    /**
     * 批量删除血氧仪
     * 
     * @param oximeterIds 需要删除的血氧仪主键
     * @return 结果
     */
    @Override
    public int deleteOximeterDataByOximeterIds(Long[] oximeterIds)
    {
        return oximeterDataMapper.deleteOximeterDataByOximeterIds(oximeterIds);
    }

    /**
     * 删除血氧仪信息
     * 
     * @param oximeterId 血氧仪主键
     * @return 结果
     */
    @Override
    public int deleteOximeterDataByOximeterId(Long oximeterId)
    {
        return oximeterDataMapper.deleteOximeterDataByOximeterId(oximeterId);
    }
}
