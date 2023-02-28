package com.unjuanable.payment.biz.extension.wechat;

import com.unjuanable.payment.biz.abs.AbstractCreatePayOrderValidator;
import com.unjuanable.payment.biz.abs.Validator;
import com.unjuanable.payment.dto.CreatePayOrderCmd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CreateWechatPayOrderValidator extends AbstractCreatePayOrderValidator implements Validator<CreatePayOrderCmd> {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void specialValidate(CreatePayOrderCmd request) {
        log.info("Begin CreateWechatPayOrderValidator.specialValidate");
    }

}
