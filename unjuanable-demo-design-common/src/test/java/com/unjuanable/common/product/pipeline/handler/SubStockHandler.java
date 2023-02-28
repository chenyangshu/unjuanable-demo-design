package com.unjuanable.common.product.pipeline.handler;

import com.unjuanable.common.pipeline.ContextHandler;
import com.unjuanable.common.product.CreateProductOrderContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 扣减库存处理器
 *
 * @author chenyangshu
 * @date 2023/02/27
 */
@Component
public class SubStockHandler implements ContextHandler<CreateProductOrderContext> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean handle(CreateProductOrderContext context) {
        logger.info("SubStockHandler.handle");
        return true;
    }
}
