package com.unjuanable.payment.biz.abs;

/**
 * 数据验证接口类
 *
 * @author
 */
public interface Validator<T> {
    /**
     * 数据验证
     *
     * @param t
     */
    void validate(T t);
}