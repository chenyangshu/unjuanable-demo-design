package com.unjuanable.common.pipeline.config;

import com.unjuanable.common.pipeline.AbstractPipelineContext;
import com.unjuanable.common.pipeline.ContextHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@ComponentScan(basePackages = {"com.unjuanable.common.pipeline"})
@Configuration
public class PipelineAutoConfiguration {

    @Bean("pipelineRouteMap")
    @ConditionalOnMissingBean(name = "pipelineRouteMap")
    public Map<Class<? extends AbstractPipelineContext>,
            List<? extends ContextHandler<? super AbstractPipelineContext>>> pipelineRouteMap() {
        return Collections.emptyMap();
    }

}