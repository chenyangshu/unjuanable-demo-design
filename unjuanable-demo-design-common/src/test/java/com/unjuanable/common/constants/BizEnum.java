package com.unjuanable.common.constants;


public enum BizEnum implements IEnum {

    BIZ_XXX("xxx", "xxx"),


    ;


    private String code;

    private String desc;

    BizEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
