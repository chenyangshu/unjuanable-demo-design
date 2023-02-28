package com.unjuanable.payment.biz.abs;

import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.cola.exception.BizException;
import com.alibaba.fastjson.JSON;
import com.unjuanable.payment.biz.extension.IPaymentExtPt;
import com.unjuanable.payment.dto.CreatePayOrderCmd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.SortedMap;
import java.util.TreeMap;

public abstract class AbstractPaymentExt<T extends Context> implements IPaymentExtPt {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());


    /**
     * 获取验证器
     *
     * @return
     */
    public abstract Validator getValidator();


    /**
     * 创建上下文信息
     *
     * @param cmd
     * @return
     */
    public abstract T createContext(CreatePayOrderCmd cmd);


    /**
     * 为下层的支付渠道的数据做好准备
     *
     * @param cmd
     * @param context
     * @throws BizException
     */
    public void prepare(CreatePayOrderCmd cmd, T context) throws BizException {
        SortedMap<String, Object> sParaTemp = new TreeMap<String, Object>();
        context.setsParaTemp(sParaTemp);
    }


    /**
     * 基本业务处理
     *
     * @param request
     * @param context
     * @return AbstractResponse
     * @throws BizException
     */
    public abstract SingleResponse generalProcess(CreatePayOrderCmd request, T context) throws BizException;

    /***
     * 基本业务处理完成后执行的后续操作
     * @param cmd
     * @param response
     * @param context
     * @return
     * @throws BizException
     */
    public abstract void afterProcess(CreatePayOrderCmd cmd, SingleResponse response, T context) throws BizException;


    @Override
    public SingleResponse process(CreatePayOrderCmd cmd) throws BizException {
        log.info("Begin AbstractPaymentExt.process:{}", JSON.toJSONString(cmd));
        SingleResponse response = null;
        //创建上下文
        T context = createContext(cmd);
        //验证
        getValidator().validate(cmd);
        //准备
        prepare(cmd, context);
        //执行
        response = generalProcess(cmd, context);
        //善后
        afterProcess(cmd, response, context);
        return response;
    }


}
