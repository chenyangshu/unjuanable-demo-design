package com.unjuanable.domain.activity.stateflow.event;

import com.unjuanable.domain.activity.ActivityStateEnum;
import com.unjuanable.domain.activity.stateflow.AbstractActivityState;
import org.springframework.stereotype.Component;

/**
 * @description: 活动开启状态
 */
@Component
public class OpenActivityState extends AbstractActivityState {

    @Override
    public ActivityStateEnum getState() {
        return ActivityStateEnum.OPEN;
    }

    @Override
    public boolean close(Long activityId, Enum<ActivityStateEnum> currentState) {
        return IActivityRepository.alterStatus(activityId, currentState, ActivityStateEnum.CLOSE);
    }


    @Override
    public boolean doing(Long activityId, Enum<ActivityStateEnum> currentState) {
        return IActivityRepository.alterStatus(activityId, currentState, ActivityStateEnum.DOING);
    }

}
