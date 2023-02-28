package com.unjuanable.payment.biz.abs;

import com.unjuanable.common.utils.ParamValidatorUtils;
import com.unjuanable.payment.dto.CreatePayOrderCmd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractCreatePayOrderValidator implements Validator<CreatePayOrderCmd> {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void validate(CreatePayOrderCmd cmd) {
        log.info("Begin AbstractCreatePayOrderValidator.validate");
        //基本参数校验
        ParamValidatorUtils.validateV2(cmd);

        //校验支付订单是否存在

        //校验支付订单是否已支付，同一订单支付幂等处理

        // 防止金额篡改等

        //特殊校验
        specialValidate(cmd);
    }

    public abstract void specialValidate(CreatePayOrderCmd request);

}
