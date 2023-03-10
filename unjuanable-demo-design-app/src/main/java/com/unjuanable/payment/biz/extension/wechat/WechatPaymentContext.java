package com.unjuanable.payment.biz.extension.wechat;

import com.unjuanable.payment.biz.abs.PaymentContext;


public class WechatPaymentContext extends PaymentContext {
    /**
     * 商品描述（必填）
     */
    private String body;
    /**
     * 终端IP
     */
    private String spbillCreateIp;

    /**
     * JSAPI--公众号支付
     * NATIVE--原生扫码支付
     * APP--app支付，统一下单接口trade_type的传参可参考这里
     * MICROPAY--刷卡支付，刷卡支付有单独的支付接口，不调用统一下单接口
     * <p>
     * 交易类型（必填）
     */
    private String tradeType;

    /**
     * 商品id
     */
    private String productId;
    /**
     * 拼接的xml格式数据，用于传递给微信服务端的参数
     */
    private String xml;


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }
}