package com.unjuanable.common;

import com.unjuanable.common.chain.OrderRegisterModel;
import com.unjuanable.common.chain.OrderRegisterResultModel;
import com.unjuanable.common.chain.ServiceFilterChainExecutorI;
import com.unjuanable.common.chain.StepContext;
import com.unjuanable.common.chain.filters.StepAFilter;
import com.unjuanable.common.chain.filters.StepBFilter;
import com.unjuanable.common.chain.filters.StepCFilter;
import com.unjuanable.common.chain.filters.StepDFilter;
import com.unjuanable.common.chain.selector.LocalListBasedFilterSelector;
import com.unjuanable.common.chain.selector.ServiceFilterSelector;
import com.unjuanable.common.constants.BizEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceFilterTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ServiceFilterChainExecutorI serviceFilterChainExecutor;

    /**
     * 测试服务过滤器链(责任链模式)
     */
    @Test
    public void test_serviceFilterChain() {
        StepContext stepContext = new StepContext(BizEnum.BIZ_XXX, getSelector());
        OrderRegisterModel orderRegisterModel = new OrderRegisterModel();
        OrderRegisterResultModel orderRegisterResultModel = new OrderRegisterResultModel();
        stepContext.setModel(orderRegisterModel);
        stepContext.setRegisterResultModel(orderRegisterResultModel);
        serviceFilterChainExecutor.execute(stepContext);
        OrderRegisterResultModel registerResultModel = stepContext.getRegisterResultModel();
        logger.info("test_serviceFilterChain registerResultModel:{}", registerResultModel);
    }

    private ServiceFilterSelector getSelector() {
        LocalListBasedFilterSelector selector = new LocalListBasedFilterSelector();
        selector.addFilter(StepAFilter.class.getSimpleName());
        selector.addFilter(StepBFilter.class.getSimpleName());
        selector.addFilter(StepCFilter.class.getSimpleName());
        selector.addFilter(StepDFilter.class.getSimpleName());
        return selector;

    }
}
