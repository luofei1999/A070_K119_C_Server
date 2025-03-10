package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.AppUpdates;

/**
 * 应用更新Mapper接口
 * 
 * @author 尹罗飞
 * @date 2025-03-10
 */
public interface AppUpdatesMapper 
{
    /**
     * 查询应用更新
     * 
     * @param id 应用更新主键
     * @return 应用更新
     */
    public AppUpdates selectAppUpdatesById(Long id);

    /**
     * 查询应用更新列表
     * 
     * @param appUpdates 应用更新
     * @return 应用更新集合
     */
    public List<AppUpdates> selectAppUpdatesList(AppUpdates appUpdates);

    public AppUpdates selectAppLatestUpdate(AppUpdates appUpdates);

    /**
     * 新增应用更新
     * 
     * @param appUpdates 应用更新
     * @return 结果
     */
    public int insertAppUpdates(AppUpdates appUpdates);

    /**
     * 修改应用更新
     * 
     * @param appUpdates 应用更新
     * @return 结果
     */
    public int updateAppUpdates(AppUpdates appUpdates);

    /**
     * 删除应用更新
     * 
     * @param id 应用更新主键
     * @return 结果
     */
    public int deleteAppUpdatesById(Long id);

    /**
     * 批量删除应用更新
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAppUpdatesByIds(Long[] ids);
}
