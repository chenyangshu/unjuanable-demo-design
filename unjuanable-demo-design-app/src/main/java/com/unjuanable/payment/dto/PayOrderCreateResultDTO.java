package com.unjuanable.payment.dto;

import com.alibaba.cola.dto.DTO;
import lombok.Data;

@Data
public class PayOrderCreateResultDTO extends DTO {
    /**
     * 构建html表单
     */
    private String htmlStr;
    /**
     * 微信支付下单的返回id
     */
    private String prepayId;
    /**
     * 微信支付下单构建的二维码地址
     */
    private String codeUrl;
}
