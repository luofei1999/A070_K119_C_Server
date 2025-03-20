package com.ruoyi.system.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.core.domain.TreeSelect;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.spring.SpringUtils;
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

    /**
     * 查询分组树结构信息
     *
     * @param group 分组信息
     * @return 部门树信息集合
     */
    @Override
    public List<DevicesGroupTreeSelect> selectSysDevicesGroupTreeList(SysDevicesGroup group)
    {
        List<SysDevicesGroup> list = SpringUtils.getAopProxy(this).selectSysDevicesGroupList(group);
        return buildDeptTreeSelect(list);
    }
    /**
     * 构建前端所需要下拉树结构
     *
     * @param groupList 分组列表
     * @return 下拉树结构列表
     */
    @Override
    public List<DevicesGroupTreeSelect> buildDeptTreeSelect(List<SysDevicesGroup> groupList)
    {
        List<SysDevicesGroup> deptTrees = buildDeptTree(groupList);
        return deptTrees.stream().map(DevicesGroupTreeSelect::new).collect(Collectors.toList());
    }

    /**
     * 构建前端所需要树结构
     *
     * @param depts 部门列表
     * @return 树结构列表
     */
    @Override
    public List<SysDevicesGroup> buildDeptTree(List<SysDevicesGroup> depts)
    {
        List<SysDevicesGroup> returnList = new ArrayList<SysDevicesGroup>();
        List<Long> tempList = depts.stream().map(SysDevicesGroup::getGroupId).collect(Collectors.toList());
        for (SysDevicesGroup dept : depts)
        {
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(dept.getParentId()))
            {
                recursionFn(depts, dept);
                returnList.add(dept);
            }
        }
        if (returnList.isEmpty())
        {
            returnList = depts;
        }
        return returnList;
    }

    private void recursionFn(List<SysDevicesGroup> list, SysDevicesGroup t)
    {
        // 得到子节点列表
        List<SysDevicesGroup> childList = getChildList(list, t);
        t.setChildren(childList);
        for (SysDevicesGroup tChild : childList)
        {
            if (hasChild(list, tChild))
            {
                recursionFn(list, tChild);
            }
        }
    }
    private List<SysDevicesGroup> getChildList(List<SysDevicesGroup> list, SysDevicesGroup t)
    {
        List<SysDevicesGroup> tlist = new ArrayList<SysDevicesGroup>();
        Iterator<SysDevicesGroup> it = list.iterator();
        while (it.hasNext())
        {
            SysDevicesGroup n = (SysDevicesGroup) it.next();
            if (StringUtils.isNotNull(n.getParentId()) && n.getParentId().longValue() == t.getGroupId().longValue())
            {
                tlist.add(n);
            }
        }
        return tlist;
    }
    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<SysDevicesGroup> list, SysDevicesGroup t)
    {
        return getChildList(list, t).size() > 0;
    }
}
