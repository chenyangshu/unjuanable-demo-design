package com.unjuanable.common.strategy;

import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Collection;
import java.util.Map;

public class StrategyFactory<T, S extends Strategy<T>> implements InitializingBean, ApplicationContextAware {


    private final Class<S> strategyType;
    private Map<T, S> strategyMap;
    private ApplicationContext appContext;

    /**
     * 创建一个策略工厂
     *
     * @param strategyType 策略的类型
     */
    public StrategyFactory(Class<S> strategyType) {
        this.strategyType = strategyType;
    }

    /**
     * 根据策略 id 获得对应的策略的 Bean
     *
     * @param id 策略 id
     * @return 策略的 Bean
     */
    public S getStrategy(T id) {
        return strategyMap.get(id);
    }

    @Override
    public void afterPropertiesSet() {
        // 获取 Spring 容器中，所有 S 类型的 Bean
        Collection<S> strategies = appContext.getBeansOfType(strategyType).values();
        strategyMap = Maps.newHashMapWithExpectedSize(strategies.size());
        // 将 所有 S 类型的 Bean 放入到 strategyMap 中
        for (final S strategy : strategies) {
            T id = strategy.getId();
            strategyMap.put(id, strategy);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appContext = applicationContext;
    }
}
