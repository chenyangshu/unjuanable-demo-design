package com.unjuanable.domain.activity.stateflow;

import com.alibaba.cola.exception.BizException;
import com.alibaba.cola.exception.ExceptionFactory;
import com.unjuanable.domain.activity.ActivityStateEnum;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ActivityStateConfig {
    protected Map<ActivityStateEnum, AbstractActivityState> stateGroup = new ConcurrentHashMap<>();
    private List<AbstractActivityState> orderStateList;

    public ActivityStateConfig(List<AbstractActivityState> orderStateList) {
        this.orderStateList = orderStateList;
    }

    @PostConstruct
    public void init() throws BizException {
        for (AbstractActivityState orderState : orderStateList) {
            stateGroup.put(orderState.getState(), orderState);
        }
    }

    public AbstractActivityState getHandler(ActivityStateEnum statusEnum) throws BizException {
        if (!stateGroup.containsKey(statusEnum)) {
            throw ExceptionFactory.bizException("state handler not exist");
        }
        return stateGroup.get(statusEnum);
    }

}
