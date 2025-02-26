package com.ruoyi.patient.service;

import java.util.List;
import com.ruoyi.patient.domain.OximeterData;

/**
 * 血氧仪Service接口
 * 
 * @author 尹罗飞
 * @date 2025-02-26
 */
public interface IOximeterDataService 
{
    /**
     * 查询血氧仪
     * 
     * @param oximeterId 血氧仪主键
     * @return 血氧仪
     */
    public OximeterData selectOximeterDataByOximeterId(Long oximeterId);

    /**
     * 查询血氧仪列表
     * 
     * @param oximeterData 血氧仪
     * @return 血氧仪集合
     */
    public List<OximeterData> selectOximeterDataList(OximeterData oximeterData);

    /**
     * 新增血氧仪
     * 
     * @param oximeterData 血氧仪
     * @return 结果
     */
    public int insertOximeterData(OximeterData oximeterData);

    /**
     * 修改血氧仪
     * 
     * @param oximeterData 血氧仪
     * @return 结果
     */
    public int updateOximeterData(OximeterData oximeterData);

    /**
     * 批量删除血氧仪
     * 
     * @param oximeterIds 需要删除的血氧仪主键集合
     * @return 结果
     */
    public int deleteOximeterDataByOximeterIds(Long[] oximeterIds);

    /**
     * 删除血氧仪信息
     * 
     * @param oximeterId 血氧仪主键
     * @return 结果
     */
    public int deleteOximeterDataByOximeterId(Long oximeterId);
}
