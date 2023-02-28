package com.unjuanable.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public interface MethodAdviceHandler<R> {

    default boolean onBefore(ProceedingJoinPoint point) {
        return true;
    }

    default R getOnForbid(ProceedingJoinPoint point) {
        return null;
    }

    void onThrow(ProceedingJoinPoint point, Throwable e);

    default R getOnThrow(ProceedingJoinPoint point, Throwable e) {
        return null;
    }

    default void onComplete(ProceedingJoinPoint point, long startTime, boolean permitted, boolean thrown, Object result) {
    }

}
