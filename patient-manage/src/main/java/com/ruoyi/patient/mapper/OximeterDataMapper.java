package com.ruoyi.patient.mapper;

import java.util.List;
import com.ruoyi.patient.domain.OximeterData;

/**
 * 血氧仪Mapper接口
 * 
 * @author 尹罗飞
 * @date 2025-02-26
 */
public interface OximeterDataMapper 
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
     * 删除血氧仪
     * 
     * @param oximeterId 血氧仪主键
     * @return 结果
     */
    public int deleteOximeterDataByOximeterId(Long oximeterId);

    /**
     * 批量删除血氧仪
     * 
     * @param oximeterIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOximeterDataByOximeterIds(Long[] oximeterIds);
}
