package com.unjuanable.payment.biz.abs;

import java.util.SortedMap;

public class Context {

    SortedMap<String, Object> sParaTemp;

    public Context() {
        super();
    }

    public SortedMap<String, Object> getsParaTemp() {
        return sParaTemp;
    }

    public void setsParaTemp(SortedMap<String, Object> sParaTemp) {
        this.sParaTemp = sParaTemp;
    }
}