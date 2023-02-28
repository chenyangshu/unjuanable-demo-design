package com.unjuanable.payment.biz.extension;

import com.alibaba.cola.dto.DTO;
import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.cola.exception.BizException;
import com.alibaba.cola.extension.ExtensionPointI;
import com.unjuanable.payment.dto.CreatePayOrderCmd;
import com.unjuanable.payment.dto.PaymentNotifyCmd;

public interface IPaymentExtPt extends ExtensionPointI {
    /**
     * 发起交易执行的过程
     *
     * @param cmd
     * @return
     * @throws BizException
     */
    SingleResponse process(CreatePayOrderCmd cmd) throws BizException;


    /**
     * 完成交易结果的处理
     *
     * @param cmd
     * @return
     * @throws BizException
     */
    <D extends DTO> D completePayment(PaymentNotifyCmd cmd) throws BizException;

}
