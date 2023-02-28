package com.unjuanable.domain.activity;

import org.springframework.stereotype.Repository;

@Repository
public interface IActivityRepository {


    /**
     * 变更活动状态
     *
     * @param activityId  活动ID
     * @param beforeState 修改前状态
     * @param afterState  修改后状态
     * @return 更新结果
     */
    boolean alterStatus(Long activityId, Enum<ActivityStateEnum> beforeState, Enum<ActivityStateEnum> afterState);

}