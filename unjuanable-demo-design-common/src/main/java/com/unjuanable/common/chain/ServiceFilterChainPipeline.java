package com.unjuanable.common.chain;

public class ServiceFilterChainPipeline<T extends ServiceFilter> {
    private DefaultFilterChain last;

    public ServiceFilterChainPipeline() {
    }

    public DefaultFilterChain getFilterChain() {
        return this.last;
    }

    public ServiceFilterChainPipeline addFilter(T filter) {
        DefaultFilterChain newChain = new DefaultFilterChain(this.last, filter);
        this.last = newChain;
        return this;
    }

    public ServiceFilterChainPipeline addFilter(String desc, T filter) {
        DefaultFilterChain newChain = new DefaultFilterChain(this.last, filter);
        this.last = newChain;
        return this;
    }
}