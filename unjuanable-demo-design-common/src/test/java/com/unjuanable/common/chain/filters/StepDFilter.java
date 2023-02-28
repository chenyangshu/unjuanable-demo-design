package com.unjuanable.common.chain.filters;

import com.unjuanable.common.chain.AbstractServiceFilter;
import com.unjuanable.common.chain.OrderRegisterResultModel;
import com.unjuanable.common.chain.StepContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StepDFilter extends AbstractServiceFilter<StepContext> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void handle(StepContext context) {
        logger.info("begin StepDFilter.handle");
        OrderRegisterResultModel registerResultModel = context.getRegisterResultModel();
        registerResultModel.setId(100l);
        context.setRegisterResultModel(registerResultModel);
    }

}
