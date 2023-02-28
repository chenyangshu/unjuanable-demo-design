package com.unjuanable.common.pipeline;

public interface ContextHandler<T extends AbstractPipelineContext> {

    boolean handle(T context);

}
