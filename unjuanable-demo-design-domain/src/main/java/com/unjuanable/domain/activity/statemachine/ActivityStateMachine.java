package com.unjuanable.domain.activity.statemachine;

import com.alibaba.cola.statemachine.Action;
import com.alibaba.cola.statemachine.Condition;
import com.alibaba.cola.statemachine.StateMachine;
import com.alibaba.cola.statemachine.builder.StateMachineBuilder;
import com.alibaba.cola.statemachine.builder.StateMachineBuilderFactory;
import com.alibaba.cola.statemachine.impl.Debugger;
import com.unjuanable.domain.activity.ActivityStateEnum;
import com.unjuanable.domain.activity.IActivityRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ActivityStateMachine implements ApplicationListener<ContextRefreshedEvent> {

    @Resource
    private IActivityRepository IActivityRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Debugger.enableDebug();
        StateMachineBuilder<ActivityStateEnum, ActivityEventEnum, ActivityContext> builder = StateMachineBuilderFactory.create();

        //ActivityStateEnum.ARRAIGNMENT
        builder.externalTransition()
                .from(ActivityStateEnum.ARRAIGNMENT)
                .to(ActivityStateEnum.PASS)
                .on(ActivityEventEnum.CHECK_PASS)
                .when(checkCondition())
                .perform(doAction());

        builder.externalTransition()
                .from(ActivityStateEnum.ARRAIGNMENT)
                .to(ActivityStateEnum.REFUSE)
                .on(ActivityEventEnum.CHECK_REFUSE)
                .when(checkCondition())
                .perform(doAction());


        builder.externalTransition()
                .from(ActivityStateEnum.ARRAIGNMENT)
                .to(ActivityStateEnum.EDIT)
                .on(ActivityEventEnum.CHECK_REVOKE)
                .when(checkCondition())
                .perform(doAction());

        //ActivityStateEnum.CLOSE
        builder.externalTransition()
                .from(ActivityStateEnum.CLOSE)
                .to(ActivityStateEnum.OPEN)
                .on(ActivityEventEnum.OPEN)
                .when(checkCondition())
                .perform(doAction());


        //ActivityStateEnum.DOING
        builder.externalTransition()
                .from(ActivityStateEnum.DOING)
                .to(ActivityStateEnum.CLOSE)
                .on(ActivityEventEnum.CLOSE)
                .when(checkCondition())
                .perform(doAction());


        //ActivityStateEnum.EDIT
        builder.externalTransition()
                .from(ActivityStateEnum.EDIT)
                .to(ActivityStateEnum.ARRAIGNMENT)
                .on(ActivityEventEnum.ARRAIGNMENT)
                .when(checkCondition())
                .perform(doAction());


        builder.externalTransition()
                .from(ActivityStateEnum.EDIT)
                .to(ActivityStateEnum.CLOSE)
                .on(ActivityEventEnum.CLOSE)
                .when(checkCondition())
                .perform(doAction());

        //ActivityStateEnum.OPEN
        builder.externalTransition()
                .from(ActivityStateEnum.OPEN)
                .to(ActivityStateEnum.CLOSE)
                .on(ActivityEventEnum.CLOSE)
                .when(checkCondition())
                .perform(doAction());


        builder.externalTransition()
                .from(ActivityStateEnum.OPEN)
                .to(ActivityStateEnum.CLOSE)
                .on(ActivityEventEnum.DOING)
                .when(checkCondition())
                .perform(doAction());

        //ActivityStateEnum.PASS
        builder.externalTransition()
                .from(ActivityStateEnum.PASS)
                .to(ActivityStateEnum.REFUSE)
                .on(ActivityEventEnum.CHECK_REFUSE)
                .when(checkCondition())
                .perform(doAction());


        builder.externalTransition()
                .from(ActivityStateEnum.PASS)
                .to(ActivityStateEnum.CLOSE)
                .on(ActivityEventEnum.CLOSE)
                .when(checkCondition())
                .perform(doAction());

        builder.externalTransition()
                .from(ActivityStateEnum.PASS)
                .to(ActivityStateEnum.DOING)
                .on(ActivityEventEnum.DOING)
                .when(checkCondition())
                .perform(doAction());

        //ActivityStateEnum.REFUSE
        builder.externalTransition()
                .from(ActivityStateEnum.REFUSE)
                .to(ActivityStateEnum.EDIT)
                .on(ActivityEventEnum.CHECK_REVOKE)
                .when(checkCondition())
                .perform(doAction());


        builder.externalTransition()
                .from(ActivityStateEnum.REFUSE)
                .to(ActivityStateEnum.CLOSE)
                .on(ActivityEventEnum.CLOSE)
                .when(checkCondition())
                .perform(doAction());

        StateMachine<ActivityStateEnum, ActivityEventEnum, ActivityContext> stateMachine = builder.build(StateMachineEnum.ACTIVITY.getCode());

//        stateMachine.showStateMachine();
        String plantUML = stateMachine.generatePlantUML();
        System.out.println(plantUML);
    }


    private Condition<ActivityContext> checkCondition() {
        return new Condition<ActivityContext>() {
            @Override
            public boolean isSatisfied(ActivityContext context) {
                System.out.println("Check condition : " + context);
                return true;
            }
        };
    }

    private Action<ActivityStateEnum, ActivityEventEnum, ActivityContext> doAction() {
        return (from, to, event, ctx) -> {
            boolean result = IActivityRepository.alterStatus(ctx.getEntityId(), ctx.getBeforeState(), to);
            ctx.setAlterResult(result);
            ctx.setAfterState(to);
            System.out.println(
                    ctx.operator + " is operating " + ctx.entityId + " from:" + from + " to:" + to + " on:" + event);
        };
    }


}
