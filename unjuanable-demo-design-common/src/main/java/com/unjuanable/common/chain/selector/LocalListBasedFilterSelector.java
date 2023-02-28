package com.unjuanable.common.chain.selector;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LocalListBasedFilterSelector implements ServiceFilterSelector {

    private List<String> filterNames = new ArrayList<>();

    public LocalListBasedFilterSelector() {
    }

    public LocalListBasedFilterSelector(List<String> filterNames) {
        this.filterNames = filterNames;
    }

    @Override
    public boolean matchFilter(String classSimpleName) {
        return filterNames.stream().anyMatch(s -> Objects.equals(s, classSimpleName));
    }

    @Override
    public List<String> getFilterNames() {
        return filterNames;
    }

    public void addFilter(String clsNames) {
        filterNames.add(clsNames);
    }

    public void addFilters(List<String> filterNames) {
        filterNames.addAll(filterNames);
    }
}