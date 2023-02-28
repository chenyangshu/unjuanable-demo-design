package com.unjuanable.payment.dto;

import com.alibaba.cola.dto.DTO;
import lombok.Data;

@Data
public class PaymentNotifyResponse extends DTO {

    private static final long serialVersionUID = 7505997295595095971L;
    private String code;
    private String msg;

    /**
     * 返回给服务端的执行结果的报文
     */
    private String result;


    @Override
    public String toString() {
        return "PaymentNotifyResponse{" +
                "result='" + result + '\'' +
                "} " + super.toString();
    }
}