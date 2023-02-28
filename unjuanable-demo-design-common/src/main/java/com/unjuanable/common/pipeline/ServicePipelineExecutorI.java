package com.unjuanable.common.pipeline;

public interface ServicePipelineExecutorI {

    <T extends AbstractPipelineContext> boolean execute(T context);
}
