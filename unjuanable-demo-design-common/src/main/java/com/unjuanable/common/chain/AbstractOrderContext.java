package com.unjuanable.common.chain;

import com.unjuanable.common.chain.selector.ServiceFilterSelector;
import com.unjuanable.common.constants.IEnum;

public abstract class AbstractOrderContext implements ServiceFilterContext {

    private final IEnum bizEnum;
    private final ServiceFilterSelector selector;

    public AbstractOrderContext(IEnum bizEnum, ServiceFilterSelector selector) {
        this.bizEnum = bizEnum;
        this.selector = selector;
    }

    @Override
    public String getBizCode() {
        return bizEnum.getCode();
    }

    @Override
    public ServiceFilterSelector getServiceFilterSelector() {
        return selector;
    }
}