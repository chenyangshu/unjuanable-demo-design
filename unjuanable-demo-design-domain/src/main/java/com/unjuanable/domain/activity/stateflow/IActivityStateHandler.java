package com.unjuanable.domain.activity.stateflow;


import com.unjuanable.domain.activity.ActivityStateEnum;

public interface IActivityStateHandler {


    /**
     * 提审
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return 审核结果
     */
    boolean arraignment(Long activityId, Enum<ActivityStateEnum> currentStatus);

    /**
     * 审核通过
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return 审核结果
     */
    boolean checkPass(Long activityId, Enum<ActivityStateEnum> currentStatus);

    /**
     * 审核拒绝
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return 审核结果
     */
    boolean checkRefuse(Long activityId, Enum<ActivityStateEnum> currentStatus);

    /**
     * 撤销审核
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return 审核结果
     */
    boolean checkRevoke(Long activityId, Enum<ActivityStateEnum> currentStatus);

    /**
     * 关闭
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return 审核结果
     */
    boolean close(Long activityId, Enum<ActivityStateEnum> currentStatus);

    /**
     * 开启
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return 审核结果
     */
    boolean open(Long activityId, Enum<ActivityStateEnum> currentStatus);

    /**
     * 运行活动中
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return 审核结果
     */
    boolean doing(Long activityId, Enum<ActivityStateEnum> currentStatus);

}
