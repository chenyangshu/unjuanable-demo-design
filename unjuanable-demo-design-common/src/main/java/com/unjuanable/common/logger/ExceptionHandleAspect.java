package com.unjuanable.common.logger;

import com.unjuanable.common.aop.BaseMethodAspect;
import com.unjuanable.common.aop.MethodAdviceHandler;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(10)
@Component
public class ExceptionHandleAspect extends BaseMethodAspect {

    @Override
    @Pointcut("@annotation(com.unjuanable.common.logger.ExceptionHandleAnno)")
    protected void pointcut() {
    }

    @Override
    protected Class<? extends MethodAdviceHandler<?>> getAdviceHandlerType() {
        return ExceptionHandleHandler.class;
    }


}
