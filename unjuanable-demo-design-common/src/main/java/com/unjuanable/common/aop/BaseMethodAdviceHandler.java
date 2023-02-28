package com.unjuanable.common.aop;

import cn.hutool.json.JSONUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public abstract class BaseMethodAdviceHandler<R> implements MethodAdviceHandler<R> {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onThrow(ProceedingJoinPoint point, Throwable e) {
        String methodDesc = getMethodDesc(point);
        Object[] args = point.getArgs();
        logger.error("{} 执行时出错，入参={}", methodDesc, JSONUtil.toJsonStr(args), e);
    }


    protected Method getTargetMethod(ProceedingJoinPoint point) {
        Signature signature = point.getSignature();

        return ((MethodSignature) signature).getMethod();
    }


    protected String getMethodDesc(ProceedingJoinPoint point) {

        Object target = point.getTarget();
        String className = target.getClass().getSimpleName();

        Signature signature = point.getSignature();
        String methodName = signature.getName();

        return className + "." + methodName;
    }
}
