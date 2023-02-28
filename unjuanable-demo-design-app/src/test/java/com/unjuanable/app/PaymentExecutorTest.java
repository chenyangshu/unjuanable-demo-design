package com.unjuanable.app;

import com.alibaba.cola.dto.SingleResponse;
import com.unjuanable.payment.constants.PayChannelEnum;
import com.unjuanable.payment.dto.CreatePayOrderCmd;
import com.unjuanable.payment.executor.CreatePayOrderCmdExe;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentExecutorTest {

    @Autowired
    private CreatePayOrderCmdExe createPayOrderCmdExe;


    @Test
    public void testCreatePayOrderCmdExe() {
        CreatePayOrderCmd cmd = new CreatePayOrderCmd();
        cmd.setUserId(1L);
        cmd.setTradeNo("1");
        cmd.setTotalFee(new BigDecimal("100"));
        cmd.setOrderFee(new BigDecimal("100"));
        cmd.setSubject("subject");
        cmd.setSpbillCreateIp("127.0.0.1");
        cmd.setPayChannel(PayChannelEnum.ALI_PAY.getCode());
        cmd.setAddressId(1L);
        SingleResponse response = createPayOrderCmdExe.execute(cmd);
    }


}
