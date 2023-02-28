package com.unjuanable.web;

import com.alibaba.cola.dto.SingleResponse;
import com.unjuanable.payment.dto.CreatePayOrderCmd;
import com.unjuanable.payment.executor.CreatePayOrderCmdExe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/cashier")
public class PayController {

    @Resource
    private CreatePayOrderCmdExe createPayOrderCmdExe;

    @PostMapping("/pay")
    public SingleResponse pay(@RequestBody CreatePayOrderCmd cmd) {
        return createPayOrderCmdExe.execute(cmd);
    }


}
