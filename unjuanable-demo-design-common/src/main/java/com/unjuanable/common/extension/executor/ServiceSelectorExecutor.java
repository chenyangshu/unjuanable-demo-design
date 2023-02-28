package com.unjuanable.common.extension.executor;

import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ServiceSelectorExecutor extends AbstractServiceSelectorExecutor implements
        ApplicationContextAware, SmartInitializingSingleton {

    private ApplicationContext applicationContext;

    private Map<String, Object> extBeans = new ConcurrentHashMap<>();

    @Override
    public <S> S selectService(BizScene bizScene, Class<S> clazz) {
        if (Objects.isNull(extBeans.get(bizScene.getBizId()))) {
            throw new RuntimeException("not find service");
        }
        return (S) extBeans.get(bizScene.getBizId());
    }

    @Override
    public void afterSingletonsInstantiated() {
        Map<String, Object> extensionBeans = this.applicationContext.getBeansWithAnnotation(
                Extension.class);
        extensionBeans.entrySet().stream().forEach(ey -> {
            Class<?> extClazz = ey.getValue().getClass();
            if (AopUtils.isAopProxy(ey.getValue())) {
                extClazz = ClassUtils.getUserClass(ey.getValue());
            }
            Extension extensionPlus = AnnotationUtils.findAnnotation(extClazz,
                    Extension.class);
            Object pre = extBeans.put(extensionPlus.bizId(), ey.getValue());
            if (Objects.nonNull(pre)) {
                throw new RuntimeException("bizId has exist!!");
            }
        });
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}