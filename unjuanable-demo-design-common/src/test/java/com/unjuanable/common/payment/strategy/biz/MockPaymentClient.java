package com.unjuanable.common.payment.strategy.biz;

import com.unjuanable.common.constants.PayChannelEnum;
import com.unjuanable.common.payment.dto.CreatePayOrderRequest;
import com.unjuanable.common.payment.dto.CreatePayOrderResponse;
import com.unjuanable.common.payment.strategy.IPaymentClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MockPaymentClient implements IPaymentClient {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public String getPayChannel() {
        return PayChannelEnum.MOCK_PAY.getCode();
    }

    @Override
    public CreatePayOrderResponse pay(CreatePayOrderRequest createPayOrderRequest) {
        log.info("MockPaymentClient.pay");
        return null;
    }
}
