package com.unjuanable.domain.activity.stateflow;

import com.alibaba.cola.exception.ExceptionFactory;
import com.unjuanable.domain.activity.ActivityStateEnum;
import com.unjuanable.domain.activity.IActivityRepository;

import javax.annotation.Resource;

public abstract class AbstractActivityState {

    @Resource
    protected IActivityRepository IActivityRepository;

    public abstract ActivityStateEnum getState();

    public boolean arraignment(Long activityId, Enum<ActivityStateEnum> currentStatus) {
        throw ExceptionFactory.bizException("not support operation");
    }


    public boolean checkPass(Long activityId, Enum<ActivityStateEnum> currentStatus) {
        throw ExceptionFactory.bizException("not support operation");
    }


    public boolean checkRefuse(Long activityId, Enum<ActivityStateEnum> currentStatus) {
        throw ExceptionFactory.bizException("not support operation");
    }


    public boolean checkRevoke(Long activityId, Enum<ActivityStateEnum> currentStatus) {
        throw ExceptionFactory.bizException("not support operation");
    }


    public boolean close(Long activityId, Enum<ActivityStateEnum> currentStatus) {
        throw ExceptionFactory.bizException("not support operation");
    }


    public boolean open(Long activityId, Enum<ActivityStateEnum> currentStatus) {
        throw ExceptionFactory.bizException("not support operation");
    }


    public boolean doing(Long activityId, Enum<ActivityStateEnum> currentStatus) {
        throw ExceptionFactory.bizException("not support operation");
    }
}