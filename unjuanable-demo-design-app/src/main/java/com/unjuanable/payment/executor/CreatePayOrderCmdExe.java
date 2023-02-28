package com.unjuanable.payment.executor;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.cola.extension.ExtensionExecutor;
import com.unjuanable.payment.biz.extension.IPaymentExtPt;
import com.unjuanable.payment.dto.CreatePayOrderCmd;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@CatchAndLog
@Component
public class CreatePayOrderCmdExe {
    @Resource
    private ExtensionExecutor extensionExecutor;

    public SingleResponse execute(CreatePayOrderCmd cmd) {
        return extensionExecutor.execute(IPaymentExtPt.class, cmd.getBizScenario(), ex -> ex.process(cmd));
    }
}
