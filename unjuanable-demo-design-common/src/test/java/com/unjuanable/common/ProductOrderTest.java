package com.unjuanable.common;

import com.unjuanable.common.pipeline.ServicePipelineExecutorI;
import com.unjuanable.common.product.CreateProductOrderContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductOrderTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ServicePipelineExecutorI servicePipelineExecutorI;

    /**
     * 测试创建产品订单(管道模式)
     */
    @Test
    public void test_createProductOrder_pipeline() {
        CreateProductOrderContext createProductOrderContext = new CreateProductOrderContext();
        boolean result = servicePipelineExecutorI.execute(createProductOrderContext);
        logger.info("test_createProductOrderContext_pipeline result:{}", result);

    }


}
