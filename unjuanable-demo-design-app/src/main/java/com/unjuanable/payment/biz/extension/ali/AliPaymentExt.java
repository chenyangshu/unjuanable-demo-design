package com.unjuanable.payment.biz.extension.ali;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.cola.exception.BizException;
import com.alibaba.cola.extension.Extension;
import com.unjuanable.domain.payment.PayOrderRepository;
import com.unjuanable.payment.biz.abs.AbstractPaymentExt;
import com.unjuanable.payment.biz.abs.Validator;
import com.unjuanable.payment.biz.extension.IPaymentExtPt;
import com.unjuanable.payment.constants.BizScenarioConstant;
import com.unjuanable.payment.dto.CreatePayOrderCmd;
import com.unjuanable.payment.dto.PayOrderCreateResultDTO;
import com.unjuanable.payment.dto.PaymentNotifyCmd;
import com.unjuanable.payment.dto.PaymentNotifyResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

@Extension(bizId = BizScenarioConstant.BIZ_PAYMENT, useCase = BizScenarioConstant.USE_CASE_PAYMENT, scenario = BizScenarioConstant.SCENARIO_ALI_PAY)
public class AliPaymentExt extends AbstractPaymentExt<AliPaymentContext> implements IPaymentExtPt {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    @Resource
    private CreateAliPayOrderValidator validator;
    @Resource
    private PayOrderRepository payOrderRepository;

    @Override
    public Validator getValidator() {
        return validator;
    }

    @Override
    public AliPaymentContext createContext(CreatePayOrderCmd cmd) {
        log.info("Begin AliPaymentExt.createContext");
        AliPaymentContext aliPaymentContext = new AliPaymentContext();
        //组装上下文
        return aliPaymentContext;
    }

    @CatchAndLog
    @Override
    public void prepare(CreatePayOrderCmd cmd, AliPaymentContext context) throws BizException {
        log.info("Begin AliPaymentExt.prepare");
        super.prepare(cmd, context);
        //构建微信支付接口请求体


    }

    @Override
    public SingleResponse generalProcess(CreatePayOrderCmd request, AliPaymentContext context) throws BizException {
        log.info("Begin AliPaymentExt.generalProcess");
        PayOrderCreateResultDTO resultDTO = new PayOrderCreateResultDTO();
        //请求微信支付接口
        //将响应结果存储到上下文context
        //组装返回结果
        return SingleResponse.of(resultDTO);
    }

    @Override
    public void afterProcess(CreatePayOrderCmd cmd, SingleResponse response, AliPaymentContext context) throws BizException {
        log.info("Begin AliPaymentExt.afterProcess");
        //插入支付表
    }

    @Override
    public PaymentNotifyResponse completePayment(PaymentNotifyCmd cmd) throws BizException {
        log.info("Begin AliPaymentExt.completePayment");
        PaymentNotifyResponse paymentNotifyResponse = new PaymentNotifyResponse();
        //验证签名
        //组装返回结果
        //更新支付订单状态
        //更新商品订单状态
        return paymentNotifyResponse;
    }
}
