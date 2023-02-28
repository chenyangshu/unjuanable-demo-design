package com.unjuanable.domain.activity.stateflow.impl;

import com.unjuanable.domain.activity.ActivityStateEnum;
import com.unjuanable.domain.activity.stateflow.AbstractActivityState;
import com.unjuanable.domain.activity.stateflow.ActivityStateConfig;
import com.unjuanable.domain.activity.stateflow.IActivityStateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActivityStateHandlerImpl extends ActivityStateConfig implements IActivityStateHandler {

    @Autowired
    public ActivityStateHandlerImpl(List<AbstractActivityState> orderStateList) {
        super(orderStateList);
    }

    @Override
    public boolean arraignment(Long activityId, Enum<ActivityStateEnum> currentStatus) {
        return stateGroup.get(currentStatus).arraignment(activityId, currentStatus);
    }

    @Override
    public boolean checkPass(Long activityId, Enum<ActivityStateEnum> currentStatus) {
        return stateGroup.get(currentStatus).checkPass(activityId, currentStatus);
    }

    @Override
    public boolean checkRefuse(Long activityId, Enum<ActivityStateEnum> currentStatus) {
        return stateGroup.get(currentStatus).checkRefuse(activityId, currentStatus);
    }

    @Override
    public boolean checkRevoke(Long activityId, Enum<ActivityStateEnum> currentStatus) {
        return stateGroup.get(currentStatus).checkRevoke(activityId, currentStatus);
    }

    @Override
    public boolean close(Long activityId, Enum<ActivityStateEnum> currentStatus) {
        return stateGroup.get(currentStatus).close(activityId, currentStatus);
    }

    @Override
    public boolean open(Long activityId, Enum<ActivityStateEnum> currentStatus) {
        return stateGroup.get(currentStatus).open(activityId, currentStatus);
    }

    @Override
    public boolean doing(Long activityId, Enum<ActivityStateEnum> currentStatus) {
        return stateGroup.get(currentStatus).doing(activityId, currentStatus);
    }
}
