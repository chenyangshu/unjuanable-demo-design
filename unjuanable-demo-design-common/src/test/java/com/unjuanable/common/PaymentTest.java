package com.unjuanable.common;

import com.unjuanable.common.constants.PayChannelEnum;
import com.unjuanable.common.extension.executor.ServiceSelectorExecutorI;
import com.unjuanable.common.payment.dto.CreatePayOrderRequest;
import com.unjuanable.common.payment.dto.CreatePayOrderResponse;
import com.unjuanable.common.payment.extension.IPaymentExtPt;
import com.unjuanable.common.payment.strategy.IPaymentClient;
import com.unjuanable.common.strategy.StrategyFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentTest {

    @Autowired
    private StrategyFactory<String, IPaymentClient> paymentClientStrategyFactory;



    /**
     * 测试创建支付订单(策略模式)
     */
    @Test
    public void test_CreatePayOrder_strategy() {
        CreatePayOrderRequest request = new CreatePayOrderRequest();
        request.setUserId(1l);
        request.setTradeNo("1");
        request.setTotalFee(new BigDecimal("100"));
        request.setPayChannel(PayChannelEnum.WECHAT_PAY.getCode());
        paymentClientStrategyFactory.getStrategy(request.getPayChannel()).pay(request);
    }

    @Autowired
    private ServiceSelectorExecutorI serviceSelectorExecutorI;

    /**
     * 测试创建支付订单(扩展点)
     */
    @Test
    public void test_CreatePayOrder_extension() {
        CreatePayOrderRequest request = new CreatePayOrderRequest();
        request.setUserId(1l);
        request.setTradeNo("1");
        request.setTotalFee(new BigDecimal("100"));
        request.setPayChannel(PayChannelEnum.ALI_PAY.getCode());
        CreatePayOrderResponse response = serviceSelectorExecutorI.exeReturnValue(IPaymentExtPt.class,
                () -> request.getPayChannel(), ex -> ex.pay(request));
    }


}
