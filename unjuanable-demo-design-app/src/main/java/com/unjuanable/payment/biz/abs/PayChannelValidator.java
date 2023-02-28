package com.unjuanable.payment.biz.abs;

import com.unjuanable.common.constants.EnumUtils;
import com.unjuanable.payment.constants.PayChannelEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PayChannelValidator implements ConstraintValidator<PayChannel, String> {
    private String payChannel = null;

    @Override
    public void initialize(PayChannel constraintAnnotation) {
        //可以在此做一些初始化工作  例如 从获取注解中的某些值
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return EnumUtils.containsVal(PayChannelEnum.values(), value);
    }
}
