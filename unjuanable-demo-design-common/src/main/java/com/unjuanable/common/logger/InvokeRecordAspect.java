package com.unjuanable.common.logger;

import com.unjuanable.common.aop.BaseMethodAspect;
import com.unjuanable.common.aop.MethodAdviceHandler;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class InvokeRecordAspect extends BaseMethodAspect {
    @Override
    @Pointcut("@annotation(com.unjuanable.common.logger.InvokeRecordAnno)")
    protected void pointcut() {
    }

    @Override
    protected Class<? extends MethodAdviceHandler<?>> getAdviceHandlerType() {
        return InvokeRecordHandler.class;
    }
}
