package com.unjuanable.common.chain.selector;

import java.util.List;

public class DummyFilterSelector implements ServiceFilterSelector {

    @Override
    public boolean matchFilter(String currentFilterName) {
        return false;
    }

    @Override
    public List<String> getFilterNames() {
        return null;
    }
}