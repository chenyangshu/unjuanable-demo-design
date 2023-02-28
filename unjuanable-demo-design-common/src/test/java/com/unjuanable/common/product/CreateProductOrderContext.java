package com.unjuanable.common.product;

import com.unjuanable.common.pipeline.AbstractPipelineContext;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CreateProductOrderContext extends AbstractPipelineContext {

    List<CartProductDto> cartProductDtoList;
    private Long userId;
    private Long addressId;
    private String tel;
    private String userName;
    private String streetName;
    private BigDecimal orderTotal;
    private List<Long> buyProductIds;

    private String buyerNickName;

    private String uniqueKey; //业务唯一id

}
