package com.unjuanable.common.payment.extension.biz;

import com.unjuanable.common.extension.executor.Extension;
import com.unjuanable.common.payment.dto.CreatePayOrderRequest;
import com.unjuanable.common.payment.dto.CreatePayOrderResponse;
import com.unjuanable.common.payment.extension.IPaymentExtPt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Extension(bizId = "mock_pay")
public class MockPaymentExt implements IPaymentExtPt {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public CreatePayOrderResponse pay(CreatePayOrderRequest createPayOrderRequest) {
        log.info("MockPaymentExt.pay");
        return null;
    }
}
