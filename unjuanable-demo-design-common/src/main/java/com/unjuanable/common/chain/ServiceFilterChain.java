package com.unjuanable.common.chain;

public interface ServiceFilterChain<T extends ServiceFilterContext> {


    /**
     * 订单上送支付处理流程
     *
     * @param context
     */
    void handle(T context);

    /**
     * 开启下一个鉴权
     *
     * @param ctx
     */
    void fireNext(T ctx);

}