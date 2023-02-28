package com.unjuanable.common.chain;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;

@Component
public class ServiceFilterChainExecutor implements ServiceFilterChainExecutorI {

    @Resource
    private Map<Class<? extends ServiceFilterContext>, ServiceFilterChainPipeline> serviceFilterChainPipelineMap;


    @Override
    public void execute(ServiceFilterContext serviceFilterContext) {
        ServiceFilterChainPipeline serviceFilterChainPipeline = serviceFilterChainPipelineMap.get(serviceFilterContext.getClass());
        if (Objects.isNull(serviceFilterChainPipeline)) {
            throw new RuntimeException("not find service filter");
        }
        serviceFilterChainPipeline.getFilterChain().handle(serviceFilterContext);
    }
}
