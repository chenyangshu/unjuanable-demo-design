package com.unjuanable.common.chain;

public abstract class AbstractServiceFilter<T extends ServiceFilterContext> implements ServiceFilter<T> {

    @Override
    public void doFilter(T context, ServiceFilterChain chain) {
        if (context.getServiceFilterSelector().matchFilter(this.getClass().getSimpleName())) {
            handle(context);
        }
        if (context.continueChain()) {
            chain.fireNext(context);
        }
    }

    protected abstract void handle(T context);
}