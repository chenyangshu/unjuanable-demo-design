package com.unjuanable.domain.activity.stateflow.event;

import com.unjuanable.domain.activity.ActivityStateEnum;
import com.unjuanable.domain.activity.stateflow.AbstractActivityState;
import org.springframework.stereotype.Component;

/**
 * @description: 提审状态
 */
@Component
public class ArraignmentActivityState extends AbstractActivityState {

    @Override
    public ActivityStateEnum getState() {
        return ActivityStateEnum.ARRAIGNMENT;
    }

    @Override
    public boolean checkPass(Long activityId, Enum<ActivityStateEnum> currentState) {
        return IActivityRepository.alterStatus(activityId, currentState, ActivityStateEnum.PASS);

    }

    @Override
    public boolean checkRefuse(Long activityId, Enum<ActivityStateEnum> currentState) {
        return IActivityRepository.alterStatus(activityId, currentState, ActivityStateEnum.REFUSE);

    }

    @Override
    public boolean checkRevoke(Long activityId, Enum<ActivityStateEnum> currentState) {
        return IActivityRepository.alterStatus(activityId, currentState, ActivityStateEnum.EDIT);
    }


}
