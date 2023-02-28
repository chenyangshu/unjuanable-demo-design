package com.unjuanable.common.product;/**
 * Created by mic on 2019/8/1.
 */

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
public class CartProductDto implements Serializable {

    private Long productId;

    private BigDecimal salePrice;

    private Long productNum;

    private Long limitNum;

    private String checked;

    private String productName;

    private String productImg;
}
