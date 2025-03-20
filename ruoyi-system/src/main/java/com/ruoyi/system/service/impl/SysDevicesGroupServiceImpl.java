package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysDevicesGroupMapper;
import com.ruoyi.system.domain.SysDevicesGroup;
import com.ruoyi.system.service.ISysDevicesGroupService;

/**
 * 设备分组Service业务层处理
 * 
 * @author 尹罗飞
 * @date 2025-03-20
 */
@Service
public class SysDevicesGroupServiceImpl implements ISysDevicesGroupService 
{
    @Autowired
    private SysDevicesGroupMapper sysDevicesGroupMapper;

    /**
     * 查询设备分组
     * 
     * @param groupId 设备分组主键
     * @return 设备分组
     */
    @Override
    public SysDevicesGroup selectSysDevicesGroupByGroupId(Long groupId)
    {
        return sysDevicesGroupMapper.selectSysDevicesGroupByGroupId(groupId);
    }

    /**
     * 查询设备分组列表
     * 
     * @param sysDevicesGroup 设备分组
     * @return 设备分组
     */
    @Override
    public List<SysDevicesGroup> selectSysDevicesGroupList(SysDevicesGroup sysDevicesGroup)
    {
        return sysDevicesGroupMapper.selectSysDevicesGroupList(sysDevicesGroup);
    }

    /**
     * 新增设备分组
     * 
     * @param sysDevicesGroup 设备分组
     * @return 结果
     */
    @Override
    public int insertSysDevicesGroup(SysDevicesGroup sysDevicesGroup)
    {
        sysDevicesGroup.setCreateTime(DateUtils.getNowDate());
        return sysDevicesGroupMapper.insertSysDevicesGroup(sysDevicesGroup);
    }

    /**
     * 修改设备分组
     * 
     * @param sysDevicesGroup 设备分组
     * @return 结果
     */
    @Override
    public int updateSysDevicesGroup(SysDevicesGroup sysDevicesGroup)
    {
        sysDevicesGroup.setUpdateTime(DateUtils.getNowDate());
        return sysDevicesGroupMapper.updateSysDevicesGroup(sysDevicesGroup);
    }

    /**
     * 批量删除设备分组
     * 
     * @param groupIds 需要删除的设备分组主键
     * @return 结果
     */
    @Override
    public int deleteSysDevicesGroupByGroupIds(Long[] groupIds)
    {
        return sysDevicesGroupMapper.deleteSysDevicesGroupByGroupIds(groupIds);
    }

    /**
     * 删除设备分组信息
     * 
     * @param groupId 设备分组主键
     * @return 结果
     */
    @Override
    public int deleteSysDevicesGroupByGroupId(Long groupId)
    {
        return sysDevicesGroupMapper.deleteSysDevicesGroupByGroupId(groupId);
    }
}
