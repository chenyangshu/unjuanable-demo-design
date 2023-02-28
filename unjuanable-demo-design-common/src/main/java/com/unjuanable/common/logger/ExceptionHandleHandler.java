package com.unjuanable.common.logger;

import com.unjuanable.common.aop.BaseMethodAdviceHandler;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ExceptionHandleHandler extends BaseMethodAdviceHandler<Object> {

    @Override
    public void onThrow(ProceedingJoinPoint point, Throwable e) {
        super.onThrow(point, e);

    }

    @Override
    public Object getOnThrow(ProceedingJoinPoint point, Throwable e) {
        Class<?> returnType = getTargetMethod(point).getReturnType();
        if (Map.class.isAssignableFrom(returnType)) {
            Map<String, Object> result = new HashMap<>(4);
            result.put("success", false);
            result.put("message", "调用出错");
            return result;
        }

        return null;
    }


}
