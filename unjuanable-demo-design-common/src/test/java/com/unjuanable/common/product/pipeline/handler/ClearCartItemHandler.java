package com.unjuanable.common.product.pipeline.handler;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.unjuanable.common.pipeline.ContextHandler;
import com.unjuanable.common.product.CreateProductOrderContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 清除购物车项目处理程序
 *
 * @author chenyangshu
 * @date 2023/02/27
 */
@CatchAndLog
@Component
public class ClearCartItemHandler implements ContextHandler<CreateProductOrderContext> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean handle(CreateProductOrderContext context) {
//        logger.info("ClearCartItemHandler.handle");
        return true;
    }
}
