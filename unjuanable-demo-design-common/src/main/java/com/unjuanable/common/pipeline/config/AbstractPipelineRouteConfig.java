package com.unjuanable.common.pipeline.config;

import com.unjuanable.common.pipeline.AbstractPipelineContext;
import com.unjuanable.common.pipeline.ContextHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractPipelineRouteConfig implements BeanFactoryPostProcessor, ApplicationContextAware {

    protected ApplicationContext appContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appContext = applicationContext;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        configurableListableBeanFactory.registerSingleton("pipelineRouteMap", getHandlerPipelineMap());
    }

    public abstract Map<Class<? extends AbstractPipelineContext>, List<? extends ContextHandler<? extends AbstractPipelineContext>>> getHandlerPipelineMap();


    protected List<? extends ContextHandler<? extends AbstractPipelineContext>> toPipeline(
            Map.Entry<Class<? extends AbstractPipelineContext>, List<Class<? extends ContextHandler<? extends AbstractPipelineContext>>>> entry) {
        return entry.getValue()
                .stream()
                .map(appContext::getBean)
                .collect(Collectors.toList());
    }


}
