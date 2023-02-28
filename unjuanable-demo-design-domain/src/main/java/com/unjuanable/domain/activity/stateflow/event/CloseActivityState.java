package com.unjuanable.domain.activity.stateflow.event;

import com.unjuanable.domain.activity.ActivityStateEnum;
import com.unjuanable.domain.activity.stateflow.AbstractActivityState;
import org.springframework.stereotype.Component;

/**
 * @description: 活动关闭状态
 */
@Component
public class CloseActivityState extends AbstractActivityState {


    @Override
    public ActivityStateEnum getState() {
        return ActivityStateEnum.CLOSE;
    }

    @Override
    public boolean open(Long activityId, Enum<ActivityStateEnum> currentState) {
        return IActivityRepository.alterStatus(activityId, currentState, ActivityStateEnum.OPEN);
    }


}
