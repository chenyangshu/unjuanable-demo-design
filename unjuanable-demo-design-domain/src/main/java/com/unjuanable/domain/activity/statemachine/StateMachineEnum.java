package com.unjuanable.domain.activity.statemachine;


import com.unjuanable.common.constants.IEnum;

public enum StateMachineEnum implements IEnum {

    /**
     * 1：编辑
     */
    ACTIVITY("activityStateMachine", "活动"),
    ;


    private String code;

    private String desc;

    StateMachineEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
