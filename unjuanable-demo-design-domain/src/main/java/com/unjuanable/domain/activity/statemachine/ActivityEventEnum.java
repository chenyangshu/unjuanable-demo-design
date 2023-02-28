package com.unjuanable.domain.activity.statemachine;


import com.unjuanable.common.constants.IEnum;

public enum ActivityEventEnum implements IEnum {

    /**
     * 1：编辑
     */
    ARRAIGNMENT("arraignment", "提审"),
    /**
     * 2：提审
     */
    CHECK_PASS("checkPass", "审核通过"),
    /**
     * 3：撤审
     */
    CHECK_REFUSE("checkRefuse", "审核拒绝"),
    /**
     * 4：通过
     */
    CHECK_REVOKE("checkRevoke", "撤销审核"),
    /**
     * 5：运行(活动中)
     */
    CLOSE("close", "关闭"),
    /**
     * 6：拒绝
     */
    OPEN("open", "开启"),
    /**
     * 7：关闭
     */
    DOING("doing", "运行活动中");


    private String code;

    private String desc;

    ActivityEventEnum(String code, String desc) {
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
