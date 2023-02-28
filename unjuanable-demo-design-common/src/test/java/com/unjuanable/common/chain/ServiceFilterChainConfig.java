package com.unjuanable.common.chain;

import com.unjuanable.common.chain.config.AbstractServiceFilterChainConfig;
import com.unjuanable.common.chain.filters.StepAFilter;
import com.unjuanable.common.chain.filters.StepBFilter;
import com.unjuanable.common.chain.filters.StepCFilter;
import com.unjuanable.common.chain.filters.StepDFilter;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class ServiceFilterChainConfig extends AbstractServiceFilterChainConfig {

    private static final
    Map<Class<? extends ServiceFilterContext>, List<Class<? extends AbstractServiceFilter<? extends ServiceFilterContext>>>> FILTER_ROUTE_MAP = new HashMap<>(4);

    static {
        FILTER_ROUTE_MAP.put(StepContext.class,
                Arrays.asList(
                        StepAFilter.class,
                        StepBFilter.class,
                        StepCFilter.class,
                        StepDFilter.class
                ));

    }


    @Override
    public Map<Class<? extends ServiceFilterContext>, ServiceFilterChainPipeline> getServiceFilterChainPipelineMap() {
        return FILTER_ROUTE_MAP.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, this::toPipeline));
    }
}
