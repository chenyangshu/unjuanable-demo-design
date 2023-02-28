package com.unjuanable.domain.activity.stateflow.event;

import com.unjuanable.domain.activity.ActivityStateEnum;
import com.unjuanable.domain.activity.stateflow.AbstractActivityState;
import org.springframework.stereotype.Component;

/**
 * @description: 审核拒绝状态
 */
@Component
public class RefuseActivityState extends AbstractActivityState {


    @Override
    public ActivityStateEnum getState() {
        return ActivityStateEnum.REFUSE;
    }

    @Override
    public boolean checkRevoke(Long activityId, Enum<ActivityStateEnum> currentState) {
        return IActivityRepository.alterStatus(activityId, currentState, ActivityStateEnum.EDIT);

    }

    @Override
    public boolean close(Long activityId, Enum<ActivityStateEnum> currentState) {
        return IActivityRepository.alterStatus(activityId, currentState, ActivityStateEnum.CLOSE);

    }


}
