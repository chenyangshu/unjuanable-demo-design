package com.unjuanable.common.extension.executor;

import java.util.function.Consumer;
import java.util.function.Function;

public interface ServiceSelectorExecutorI {

    /**
     * 执行void 方法
     *
     * @param clazz
     * @param bizScene
     * @param consumer
     * @param <S>
     */
    <S> void exeReturnVoid(Class<S> clazz, BizScene bizScene, Consumer<S> consumer);

    /**
     * 执行有返回值的方法
     *
     * @param clazz
     * @param bizScene
     * @param function
     * @param <R>
     * @param <S>
     * @return
     */
    <R, S> R exeReturnValue(Class<S> clazz, BizScene bizScene, Function<S, R> function);

}