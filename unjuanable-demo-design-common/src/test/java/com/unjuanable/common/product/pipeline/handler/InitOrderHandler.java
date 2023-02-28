package com.unjuanable.common.product.pipeline.handler;

import com.unjuanable.common.pipeline.ContextHandler;
import com.unjuanable.common.product.CreateProductOrderContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 初始化订单处理程序
 *
 * @author chenyangshu
 * @date 2023/02/27
 */
@Component
public class InitOrderHandler implements ContextHandler<CreateProductOrderContext> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean handle(CreateProductOrderContext context) {
        logger.info("InitOrderHandler.handle");
        return true;
    }
}
