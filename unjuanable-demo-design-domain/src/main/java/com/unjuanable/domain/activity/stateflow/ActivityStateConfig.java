package com.unjuanable.domain.activity.stateflow;

import com.alibaba.cola.exception.BizException;
import com.alibaba.cola.exception.ExceptionFactory;
import com.unjuanable.domain.activity.ActivityStateEnum;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ActivityStateConfig {
    /**
     * 活动状态对应的状态处理器映射
     */
    protected Map<ActivityStateEnum, AbstractActivityState> stateGroup = new ConcurrentHashMap<>();
    /**
     * 状态处理器集合
     */
    private List<AbstractActivityState> stateList;

    public ActivityStateConfig(List<AbstractActivityState> orderStateList) {
        this.stateList = orderStateList;
    }

    /**
     * 活动状态处理器映射初始化
     *
     * @throws BizException
     */
    @PostConstruct
    public void init() throws BizException {
        for (AbstractActivityState activityState : stateList) {
            stateGroup.put(activityState.getState(), activityState);
        }
    }

    /**
     * 获取状态处理器
     *
     * @param statusEnum
     * @return
     * @throws BizException
     */
    public AbstractActivityState getHandler(ActivityStateEnum statusEnum) throws BizException {
        if (!stateGroup.containsKey(statusEnum)) {
            throw ExceptionFactory.bizException("state handler not exist");
        }
        return stateGroup.get(statusEnum);
    }

}
