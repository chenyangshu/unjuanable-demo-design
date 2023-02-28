package com.unjuanable.common.chain;

import com.unjuanable.common.chain.selector.ServiceFilterSelector;
import com.unjuanable.common.constants.IEnum;
import lombok.Getter;
import lombok.Setter;


public class StepContext extends AbstractOrderContext {

    private boolean continueFlag = true;


    @Setter
    @Getter
    private OrderRegisterModel model;

    /**
     * 注册
     */
    @Setter
    @Getter
    private OrderRegisterResultModel registerResultModel;


    public StepContext(IEnum bizEnum, ServiceFilterSelector selector) {
        super(bizEnum, selector);
    }

    @Override
    public boolean continueChain() {
        return continueFlag;
    }

    public void stopChain() {
        continueFlag = false;
    }

}
