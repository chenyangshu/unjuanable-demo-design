package com.unjuanable.common.payment.extension;

import com.unjuanable.common.payment.dto.CreatePayOrderRequest;
import com.unjuanable.common.payment.dto.CreatePayOrderResponse;

/**
 * 支付扩展点
 *
 * @author chenyangshu
 * @date 2023/02/28
 */
public interface IPaymentExtPt {
    CreatePayOrderResponse pay(CreatePayOrderRequest createPayOrderRequest);
}
