package com.unjuanable.common.logger;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.unjuanable.common.aop.BaseMethodAdviceHandler;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class InvokeRecordHandler extends BaseMethodAdviceHandler<Object> {


    @Override
    public void onComplete(ProceedingJoinPoint point, long startTime, boolean permitted, boolean thrown, Object result) {
        String methodDesc = getMethodDesc(point);
        Object[] args = point.getArgs();
        long costTime = System.currentTimeMillis() - startTime;

        logger.debug("\n{} 执行结束，耗时={}ms，入参={}, 出参={}",
                methodDesc, costTime,
                JSONUtil.toJsonStr(args),
                JSONUtil.toJsonStr(result));
    }

    @Override
    protected String getMethodDesc(ProceedingJoinPoint point) {
        Method targetMethod = getTargetMethod(point);
        InvokeRecordAnno anno = targetMethod.getAnnotation(InvokeRecordAnno.class);
        String description = anno.value();
        if (StrUtil.isBlank(description)) {
            description = super.getMethodDesc(point);
        }
        return description;
    }
}
