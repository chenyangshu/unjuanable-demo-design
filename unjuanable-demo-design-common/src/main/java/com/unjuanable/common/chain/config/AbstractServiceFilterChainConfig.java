package com.unjuanable.common.chain.config;

import com.unjuanable.common.chain.AbstractServiceFilter;
import com.unjuanable.common.chain.ServiceFilterChainPipeline;
import com.unjuanable.common.chain.ServiceFilterContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractServiceFilterChainConfig implements BeanFactoryPostProcessor, ApplicationContextAware {

    protected ApplicationContext appContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appContext = applicationContext;
    }


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        configurableListableBeanFactory.registerSingleton("serviceFilterChainPipelineMap", getServiceFilterChainPipelineMap());
    }

    public abstract Map<Class<? extends ServiceFilterContext>, ServiceFilterChainPipeline> getServiceFilterChainPipelineMap();


    protected ServiceFilterChainPipeline toPipeline(
            Map.Entry<Class<? extends ServiceFilterContext>, List<Class<? extends AbstractServiceFilter<? extends ServiceFilterContext>>>> entry) {
        List<? extends AbstractServiceFilter<? extends ServiceFilterContext>> filters = entry.getValue().stream().map(appContext::getBean).collect(Collectors.toList());
        ServiceFilterChainPipeline filterChainPipeline = new ServiceFilterChainPipeline();
//        ListIterator<? extends AbstractServiceFilter<? extends ServiceFilterContext>> listIterator = filters.listIterator(filters.size());
//        while (listIterator.hasPrevious()){
//            filterChainPipeline.addFilter(listIterator.previous());
//        }
        for (int i = filters.size() - 1; i >= 0; i--) {
            filterChainPipeline.addFilter(filters.get(i));
        }
        return filterChainPipeline;
    }
}
