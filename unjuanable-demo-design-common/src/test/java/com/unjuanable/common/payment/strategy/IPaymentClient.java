package com.unjuanable.common.payment.strategy;

import com.unjuanable.common.payment.dto.CreatePayOrderRequest;
import com.unjuanable.common.payment.dto.CreatePayOrderResponse;
import com.unjuanable.common.strategy.Strategy;

public interface IPaymentClient extends Strategy<String> {

    String getPayChannel();

    @Override
    default String getId() {
        return getPayChannel();
    }

    CreatePayOrderResponse pay(CreatePayOrderRequest createPayOrderRequest);

}
