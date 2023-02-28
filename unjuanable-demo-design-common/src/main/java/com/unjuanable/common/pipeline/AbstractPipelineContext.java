package com.unjuanable.common.pipeline;

public abstract class AbstractPipelineContext {

    public String getName() {
        return this.getClass().getSimpleName();
    }
}
