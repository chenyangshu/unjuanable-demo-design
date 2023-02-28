package com.unjuanable.common.extension.executor;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public enum BizEnum implements BizScene {

    /**
     * 默认业务
     */
    DEFAULT_BIZ("default_biz", "默认业务");

    private String bizId;
    @Getter
    private String remark;
    BizEnum(String bizId, String remark) {
        this.bizId = bizId;
        this.remark = remark;
    }

    public static Optional<BizEnum> of(String bizId) {
        return Arrays.stream(BizEnum.values())
                .filter(s -> Objects.equals(s.getBizId(), bizId)).findFirst();
    }

    @Override
    public String getBizId() {
        return this.bizId;
    }
}