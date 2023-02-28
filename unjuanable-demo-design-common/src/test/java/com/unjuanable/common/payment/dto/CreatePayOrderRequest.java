package com.unjuanable.common.payment.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreatePayOrderRequest {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 交易订单号, 统一生成全局唯一的订单号
     */
    private String tradeNo;

    /**
     * 实际支付金额(单位为分)
     */
    private BigDecimal totalFee;

    /**
     * 支付渠道（alipay：支付宝  /  wechat_pay：微信）
     */
    private String payChannel;


}
