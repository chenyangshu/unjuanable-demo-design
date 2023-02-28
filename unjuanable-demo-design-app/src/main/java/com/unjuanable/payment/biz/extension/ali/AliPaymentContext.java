package com.unjuanable.payment.biz.extension.ali;

import com.unjuanable.payment.biz.abs.PaymentContext;


public class AliPaymentContext extends PaymentContext {
    /**
     * 商品名称（必填）
     */
    private String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}