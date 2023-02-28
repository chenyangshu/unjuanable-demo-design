package com.unjuanable.domain.activity.stateflow.event;

import com.unjuanable.domain.activity.ActivityStateEnum;
import com.unjuanable.domain.activity.stateflow.AbstractActivityState;
import org.springframework.stereotype.Component;

/**
 * @description: 编辑状态
 */
@Component
public class EditingActivityState extends AbstractActivityState {

    @Override
    public ActivityStateEnum getState() {
        return ActivityStateEnum.EDIT;
    }

    @Override
    public boolean arraignment(Long activityId, Enum<ActivityStateEnum> currentState) {
        return IActivityRepository.alterStatus(activityId, currentState, ActivityStateEnum.ARRAIGNMENT);
    }

    @Override
    public boolean close(Long activityId, Enum<ActivityStateEnum> currentState) {
        return IActivityRepository.alterStatus(activityId, currentState, ActivityStateEnum.CLOSE);
    }


}
