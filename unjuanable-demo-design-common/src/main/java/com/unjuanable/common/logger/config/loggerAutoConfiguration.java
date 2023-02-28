package com.unjuanable.common.logger.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan(basePackages = {"com.unjuanable.common.logger"})
@Configuration
@EnableAspectJAutoProxy
public class loggerAutoConfiguration {

}