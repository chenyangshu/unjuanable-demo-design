package com.unjuanable.common.chain.selector;

import java.util.List;

public interface ServiceFilterSelector {

    /**
     * filter 匹配
     *
     * @param currentFilterName
     * @return
     */
    boolean matchFilter(String currentFilterName);

    /**
     * 获取所有的filterNames
     *
     * @return
     */
    List<String> getFilterNames();

}