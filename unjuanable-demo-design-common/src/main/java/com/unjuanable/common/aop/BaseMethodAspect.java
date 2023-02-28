package com.unjuanable.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public abstract class BaseMethodAspect implements ApplicationContextAware {

    private ApplicationContext appContext;

    protected abstract void pointcut();


    @Around("pointcut()")
    public Object advice(ProceedingJoinPoint point) {
        Class<? extends MethodAdviceHandler<?>> handlerType = getAdviceHandlerType();
        MethodAdviceHandler<?> adviceHandler = appContext.getBean(handlerType);
        return advice(point, adviceHandler);
    }


    protected abstract Class<? extends MethodAdviceHandler<?>> getAdviceHandlerType();


    private Object advice(ProceedingJoinPoint point, MethodAdviceHandler<?> handler) {
        boolean permitted = handler.onBefore(point);
        Object result;
        boolean thrown = false;
        long startTime = System.currentTimeMillis();
        if (permitted) {
            try {
                result = point.proceed();
            } catch (Throwable e) {
                thrown = true;
                handler.onThrow(point, e);
                result = handler.getOnThrow(point, e);
            }
        } else {
            result = handler.getOnForbid(point);
        }
        handler.onComplete(point, startTime, permitted, thrown, result);
        return result;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appContext = applicationContext;
    }
}


