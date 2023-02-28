package com.unjuanable.domain.activity.stateflow.event;

import com.unjuanable.domain.activity.ActivityStateEnum;
import com.unjuanable.domain.activity.stateflow.AbstractActivityState;
import org.springframework.stereotype.Component;

/**
 * @description: 运行(活动中)状态
 */
@Component
public class DoingActivityState extends AbstractActivityState {

    @Override
    public ActivityStateEnum getState() {
        return ActivityStateEnum.DOING;
    }

    @Override
    public boolean close(Long activityId, Enum<ActivityStateEnum> currentState) {
        return IActivityRepository.alterStatus(activityId, currentState, ActivityStateEnum.CLOSE);
    }


}
