package com.unjuanable.domain.activity;


import com.unjuanable.common.constants.IEnum;

public enum ActivityStateEnum implements IEnum {

    /**
     * 1：编辑
     */
    EDIT("1", "编辑"),
    /**
     * 2：提审
     */
    ARRAIGNMENT("2", "提审"),
    /**
     * 3：撤审
     */
    REVOKE("3", "撤审"),
    /**
     * 4：通过
     */
    PASS("4", "通过"),
    /**
     * 5：运行(活动中)
     */
    DOING("5", "运行(活动中)"),
    /**
     * 6：拒绝
     */
    REFUSE("6", "拒绝"),
    /**
     * 7：关闭
     */
    CLOSE("7", "关闭"),
    /**
     * 8：开启
     */
    OPEN("8", "开启");;


    private String code;

    private String desc;

    ActivityStateEnum(String code, String desc) {
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
