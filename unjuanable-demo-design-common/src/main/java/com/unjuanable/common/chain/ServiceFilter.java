package com.unjuanable.common.chain;

public interface ServiceFilter<T extends ServiceFilterContext> {

    /**
     * 过滤逻辑封装点
     *
     * @param context
     * @param chain
     */
    void doFilter(T context, ServiceFilterChain chain);


}