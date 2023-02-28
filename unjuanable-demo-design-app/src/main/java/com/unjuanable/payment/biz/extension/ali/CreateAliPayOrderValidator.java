package com.unjuanable.payment.biz.extension.ali;

import com.unjuanable.payment.biz.abs.AbstractCreatePayOrderValidator;
import com.unjuanable.payment.biz.abs.Validator;
import com.unjuanable.payment.dto.CreatePayOrderCmd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CreateAliPayOrderValidator extends AbstractCreatePayOrderValidator implements Validator<CreatePayOrderCmd> {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void specialValidate(CreatePayOrderCmd request) {

    }

}
