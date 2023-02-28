package com.unjuanable.common.chain.config;

import com.unjuanable.common.chain.ServiceFilterChainPipeline;
import com.unjuanable.common.chain.ServiceFilterContext;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.Map;

@ComponentScan(basePackages = {"com.unjuanable.common.chain"})
@Configuration
public class FilterAutoConfiguration {
    @ConditionalOnMissingBean(name = "serviceFilterChainPipelineMap")
    @Bean("serviceFilterChainPipelineMap")
    public Map<Class<? extends ServiceFilterContext>, ServiceFilterChainPipeline> serviceFilterChainPipelineMap() {
        return Collections.emptyMap();
    }

}