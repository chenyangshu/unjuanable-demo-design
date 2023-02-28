package com.unjuanable.common.chain.filters;

import com.unjuanable.common.chain.AbstractServiceFilter;
import com.unjuanable.common.chain.StepContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StepBFilter extends AbstractServiceFilter<StepContext> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void handle(StepContext context) {
        logger.info("begin StepBFilter.handle");
//        context.stopChain();
    }
}
