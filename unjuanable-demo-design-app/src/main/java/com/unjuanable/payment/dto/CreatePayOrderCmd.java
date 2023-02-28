package com.unjuanable.payment.dto;

import com.alibaba.cola.dto.Command;
import com.alibaba.cola.extension.BizScenario;
import com.unjuanable.payment.biz.abs.PayChannel;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class CreatePayOrderCmd extends Command {
    /**
     * 用户id
     */
    @NotNull(message = "userId不可为空")
    private Long userId;

    /**
     * 交易订单号, 统一生成全局唯一的订单号
     */
    @NotBlank(message = "tradeNo不可为空")
    private String tradeNo;

    /**
     * 实际支付金额(单位为分)
     */
    @Min(value = 0, message = "实际支付金额不能为负数")
    private BigDecimal totalFee;

    /**
     * 订单总金额
     */
    @Min(value = 0, message = "订单总金额不能为负数")
    private BigDecimal orderFee;

    /**
     * 商品描述(必填)
     * 微信支付提交格式要求；支付宝不需要严格控制格式
     * {浏览器打开的网站主页title名 -商品概述}
     */
    @NotBlank(message = "商品描述不能为空")
    private String subject;

    /**
     * 终端IP(非必填)
     */
    private String spbillCreateIp;

    /**
     * 支付渠道（alipay：支付宝  /  wechat_pay：微信）
     */
    @PayChannel
    private String payChannel;
    /**
     * 地址id
     */
    private Long addressId;


    public BizScenario getBizScenario() {
        return BizScenario.valueOf("payment", "pay", payChannel);
    }
}