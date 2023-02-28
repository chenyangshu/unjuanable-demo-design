package com.unjuanable.app;

import com.alibaba.cola.statemachine.StateMachine;
import com.alibaba.cola.statemachine.StateMachineFactory;
import com.alibaba.fastjson.JSON;
import com.unjuanable.domain.activity.ActivityStateEnum;
import com.unjuanable.domain.activity.stateflow.IActivityStateHandler;
import com.unjuanable.domain.activity.statemachine.ActivityContext;
import com.unjuanable.domain.activity.statemachine.ActivityEventEnum;
import com.unjuanable.domain.activity.statemachine.StateMachineEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivityTest {
    private Logger logger = LoggerFactory.getLogger(ActivityTest.class);
    @Autowired
    private IActivityStateHandler stateHandler;


    @Test
    public void test_alterState() {
        logger.info("提交审核，测试：{}", JSON.toJSONString(stateHandler.arraignment(100001L, ActivityStateEnum.EDIT)));
        logger.info("审核通过，测试：{}", JSON.toJSONString(stateHandler.checkPass(100001L, ActivityStateEnum.ARRAIGNMENT)));
        logger.info("运行活动，测试：{}", JSON.toJSONString(stateHandler.doing(100001L, ActivityStateEnum.PASS)));
//        logger.info("二次提审，测试：{}", JSON.toJSONString(stateHandler.checkPass(100001L, ActivityStateEnum.EDIT)));
    }


    @Test
    public void test_stateMachine() {
        StateMachine stateMachine = StateMachineFactory.get(StateMachineEnum.ACTIVITY.getCode());
        ActivityContext context = new ActivityContext();
        context.setBeforeState(ActivityStateEnum.EDIT);
        logger.info("提交审核，测试：{}", JSON.toJSONString(stateMachine.fireEvent(context.getBeforeState(), ActivityEventEnum.ARRAIGNMENT, context)));
        context.setBeforeState(ActivityStateEnum.ARRAIGNMENT);
        logger.info("审核通过，测试：{}", JSON.toJSONString(stateMachine.fireEvent(context.getBeforeState(), ActivityEventEnum.CHECK_PASS, context)));
        context.setBeforeState(ActivityStateEnum.PASS);
        logger.info("运行活动，测试：{}", JSON.toJSONString(stateMachine.fireEvent(context.getBeforeState(), ActivityEventEnum.DOING, context)));
        context.setBeforeState(ActivityStateEnum.EDIT);
        logger.info("二次提审，测试：{}", JSON.toJSONString(stateMachine.fireEvent(context.getBeforeState(), ActivityEventEnum.CHECK_PASS, context)));
    }


}
