package com.unjuanable.domain.activity.statemachine;

import com.unjuanable.domain.activity.ActivityStateEnum;
import lombok.Data;

@Data
public class ActivityContext {
    String operator = "frank";
    Long entityId = 1l;

    Enum<ActivityStateEnum> beforeState;
    Enum<ActivityStateEnum> afterState;

    private Boolean alterResult;

}
