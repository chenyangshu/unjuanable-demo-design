package com.unjuanable.payment.constants;


import com.unjuanable.common.constants.IEnum;

public enum PayChannelEnum implements IEnum {

    ALI_PAY(BizScenarioConstant.SCENARIO_ALI_PAY, "支付宝支付渠道"),
    WECHAT_PAY(BizScenarioConstant.SCENARIO_WECHAT_PAY, "微信支付渠道"),
    ALI_REFUND("ali_refund", "支付宝退款渠道"),
    WECHAT_REFUND("wechat_refund", "微信退款渠道");


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
