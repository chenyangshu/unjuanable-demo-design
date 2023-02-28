package com.unjuanable.payment.dto;

import com.alibaba.cola.dto.Command;
import lombok.Data;

import java.util.Map;

@Data
public class PaymentNotifyCmd extends Command {
    /**
     * 支付渠道（alipay：支付宝  /  wechat_pay：微信）
     */
    private String payChannel;

    private Map<String, String[]> resultMap;//服务端返回的支付通知结果

    private String xml; //微信返回的结果
}
