package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AppUpdatesMapper;
import com.ruoyi.system.domain.AppUpdates;
import com.ruoyi.system.service.IAppUpdatesService;

/**
 * 应用更新Service业务层处理
 * 
 * @author 尹罗飞
 * @date 2025-03-10
 */
@Service
public class AppUpdatesServiceImpl implements IAppUpdatesService 
{
    @Autowired
    private AppUpdatesMapper appUpdatesMapper;

    /**
     * 查询应用更新
     * 
     * @param id 应用更新主键
     * @return 应用更新
     */
    @Override
    public AppUpdates selectAppUpdatesById(Long id)
    {
        return appUpdatesMapper.selectAppUpdatesById(id);
    }

    /**
     * 查询应用更新列表
     * 
     * @param appUpdates 应用更新
     * @return 应用更新
     */
    @Override
    public List<AppUpdates> selectAppUpdatesList(AppUpdates appUpdates)
    {
        return appUpdatesMapper.selectAppUpdatesList(appUpdates);
    }

    @Override
    public AppUpdates selectAppLatestUpdate(AppUpdates appUpdates) {
        return appUpdatesMapper.selectAppLatestUpdate(appUpdates);
    }

    /**
     * 新增应用更新
     * 
     * @param appUpdates 应用更新
     * @return 结果
     */
    @Override
    public int insertAppUpdates(AppUpdates appUpdates)
    {
        appUpdates.setCreateTime(DateUtils.getNowDate());
        return appUpdatesMapper.insertAppUpdates(appUpdates);
    }

    /**
     * 修改应用更新
     * 
     * @param appUpdates 应用更新
     * @return 结果
     */
    @Override
    public int updateAppUpdates(AppUpdates appUpdates)
    {
        return appUpdatesMapper.updateAppUpdates(appUpdates);
    }

    /**
     * 批量删除应用更新
     * 
     * @param ids 需要删除的应用更新主键
     * @return 结果
     */
    @Override
    public int deleteAppUpdatesByIds(Long[] ids)
    {
        return appUpdatesMapper.deleteAppUpdatesByIds(ids);
    }

    /**
     * 删除应用更新信息
     * 
     * @param id 应用更新主键
     * @return 结果
     */
    @Override
    public int deleteAppUpdatesById(Long id)
    {
        return appUpdatesMapper.deleteAppUpdatesById(id);
    }
}
