package com.unjuanable.common.chain;

import com.unjuanable.common.chain.selector.ServiceFilterSelector;

public interface ServiceFilterContext {

    String getBizCode();

    /**
     * 获取过滤器选择器
     *
     * @return
     */
    ServiceFilterSelector getServiceFilterSelector();

    /**
     * 是否继续链
     *
     * @return
     */
    boolean continueChain();

}
