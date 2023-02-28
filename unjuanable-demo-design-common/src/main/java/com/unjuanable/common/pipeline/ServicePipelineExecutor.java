package com.unjuanable.common.pipeline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class ServicePipelineExecutor implements ServicePipelineExecutorI {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Resource
    private Map<Class<? extends AbstractPipelineContext>,
            List<? extends ContextHandler<? super AbstractPipelineContext>>> pipelineRouteMap;


    @Override
    public boolean execute(AbstractPipelineContext context) {
        Objects.requireNonNull(context, "上下文数据不能为 null");
        Class<? extends AbstractPipelineContext> dataType = context.getClass();
        List<? extends ContextHandler<? super AbstractPipelineContext>> pipeline = pipelineRouteMap.get(dataType);

        if (CollectionUtils.isEmpty(pipeline)) {
            logger.error("{} 的管道为空", dataType.getSimpleName());
            return false;
        }
        boolean lastSuccess = true;
        for (ContextHandler<? super AbstractPipelineContext> handler : pipeline) {
            try {
                lastSuccess = handler.handle(context);
            } catch (Throwable ex) {
                logger.error("[{}] 处理异常，handler={}", context.getName(), handler.getClass().getSimpleName(), ex);
                throw ex;
            }
            if (!lastSuccess) {
                break;
            }
        }
        return lastSuccess;
    }

}
