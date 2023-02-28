package com.unjuanable.common.chain;

import java.util.Objects;

public class DefaultFilterChain<T extends ServiceFilterContext> implements ServiceFilterChain<T> {

    private ServiceFilterChain<T> next;
    private ServiceFilter<T> filter;

    public DefaultFilterChain(ServiceFilterChain chain, ServiceFilter filter) {
        this.next = chain;
        this.filter = filter;
    }

    @Override
    public void handle(T context) {
        filter.doFilter(context, this);
    }

    @Override
    public void fireNext(T ctx) {
        ServiceFilterChain nextChain = this.next;
        if (Objects.nonNull(nextChain)) {
            nextChain.handle(ctx);
        }
    }
}