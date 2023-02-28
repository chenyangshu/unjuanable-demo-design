package com.unjuanable.common.payment.strategy;

import com.unjuanable.common.strategy.StrategyFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StrategyFactoryConfig {


    @Bean
    public StrategyFactory<String, IPaymentClient> paymentClientStrategyFactory() {
        return new StrategyFactory(IPaymentClient.class);
    }

}
