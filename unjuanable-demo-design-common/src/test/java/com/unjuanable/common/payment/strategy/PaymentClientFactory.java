//package com.unjuanable.common.payment.strategy;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//@Component
//public class PaymentClientFactory implements InitializingBean, ApplicationContextAware {
//    private static final Map<String, IPaymentClient> PAYMENT_CLIENT_MAP = new ConcurrentHashMap<>();
//    private ApplicationContext appContext;
//
//    public IPaymentClient getPaymentClient(String payChannel) {
//        return PAYMENT_CLIENT_MAP.get(payChannel);
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        appContext.getBeansOfType(IPaymentClient.class)
//                .values().forEach(client -> PAYMENT_CLIENT_MAP.put(client.getPayChannel(), client));
//    }
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        appContext = applicationContext;
//    }
//}
