package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysDevicesGroup;

/**
 * 设备分组Mapper接口
 * 
 * @author 尹罗飞
 * @date 2025-03-20
 */
public interface SysDevicesGroupMapper 
{
    /**
     * 查询设备分组
     * 
     * @param groupId 设备分组主键
     * @return 设备分组
     */
    public SysDevicesGroup selectSysDevicesGroupByGroupId(Long groupId);

    /**
     * 查询设备分组列表
     * 
     * @param sysDevicesGroup 设备分组
     * @return 设备分组集合
     */
    public List<SysDevicesGroup> selectSysDevicesGroupList(SysDevicesGroup sysDevicesGroup);

    /**
     * 新增设备分组
     * 
     * @param sysDevicesGroup 设备分组
     * @return 结果
     */
    public int insertSysDevicesGroup(SysDevicesGroup sysDevicesGroup);

    /**
     * 修改设备分组
     * 
     * @param sysDevicesGroup 设备分组
     * @return 结果
     */
    public int updateSysDevicesGroup(SysDevicesGroup sysDevicesGroup);

    /**
     * 删除设备分组
     * 
     * @param groupId 设备分组主键
     * @return 结果
     */
    public int deleteSysDevicesGroupByGroupId(Long groupId);

    /**
     * 批量删除设备分组
     * 
     * @param groupIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysDevicesGroupByGroupIds(Long[] groupIds);
}
