package com.unjuanable.common.product.pipeline;

import com.unjuanable.common.pipeline.AbstractPipelineContext;
import com.unjuanable.common.pipeline.ContextHandler;
import com.unjuanable.common.pipeline.config.AbstractPipelineRouteConfig;
import com.unjuanable.common.product.CreateProductOrderContext;
import com.unjuanable.common.product.pipeline.handler.*;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class PipelineRouteConfig extends AbstractPipelineRouteConfig implements ApplicationContextAware {


    private static final
    Map<Class<? extends AbstractPipelineContext>, List<Class<? extends ContextHandler<? extends AbstractPipelineContext>>>> PIPELINE_ROUTE_MAP = new HashMap<>(4);

    static {
        PIPELINE_ROUTE_MAP.put(CreateProductOrderContext.class,
                Arrays.asList(
                        ValidateHandler.class,
                        SubStockHandler.class,
                        InitOrderHandler.class,
                        LogisticalHandler.class,
                        ClearCartItemHandler.class,
                        SendMessageHandler.class
                ));
    }

    public Map<Class<? extends AbstractPipelineContext>, List<? extends ContextHandler<? extends AbstractPipelineContext>>> getHandlerPipelineMap() {
        return PIPELINE_ROUTE_MAP.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, this::toPipeline));
    }


}
