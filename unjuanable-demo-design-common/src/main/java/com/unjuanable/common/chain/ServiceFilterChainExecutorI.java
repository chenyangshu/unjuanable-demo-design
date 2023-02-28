package com.unjuanable.common.chain;

/**
 * 服务过滤器链执行器
 *
 * @author chenyangshu
 * @date 2023/02/28
 */
public interface ServiceFilterChainExecutorI {

    void execute(ServiceFilterContext serviceFilterContext);

}
