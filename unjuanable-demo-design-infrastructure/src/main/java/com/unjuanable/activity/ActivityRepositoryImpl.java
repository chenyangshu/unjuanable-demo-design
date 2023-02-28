package com.unjuanable.activity;

import com.unjuanable.domain.activity.ActivityStateEnum;
import com.unjuanable.domain.activity.IActivityRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ActivityRepositoryImpl implements IActivityRepository {


    /**
     * 变更活动状态
     *
     * @param activityId  活动ID
     * @param beforeState 修改前状态
     * @param afterState  修改后状态
     * @return 更新结果
     */
    @Override
    public boolean alterStatus(Long activityId, Enum<ActivityStateEnum> beforeState, Enum<ActivityStateEnum> afterState) {
        return true;
    }

}