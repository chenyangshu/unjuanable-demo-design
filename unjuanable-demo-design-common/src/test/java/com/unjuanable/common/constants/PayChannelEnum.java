package com.unjuanable.common.constants;


public enum PayChannelEnum implements IEnum {

    ALI_PAY("ali_pay", "支付宝支付渠道"),
    WECHAT_PAY("wechat_pay", "微信支付渠道"),
    MOCK_PAY("mock_pay", "mock支付渠道"),

    ;


    private String code;

    private String desc;

    PayChannelEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
