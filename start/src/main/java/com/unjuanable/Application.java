package com.unjuanable;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Starter
 *
 * @author
 */
@Slf4j
@SpringBootApplication(scanBasePackages = {"com.unjuanable", "com.alibaba.cola"})
public class Application {

    public static void main(String[] args) {
        try {
            SpringApplication.run(Application.class, args);
        } catch (Exception e) {
            log.error("Application run fail e", e);
        }
    }
}
