package com.unjuanable.common.constants;

public class EnumUtils {


    public static boolean equalsVal(IEnum en, Object code) {
        if (code == null) {
            return false;
        }
        if (en.getClass().equals(code.getClass())) {
            return en == code;
        }
        return en.getCode().equals(code);
    }

    public static boolean containsVal(IEnum[] ens, Object code) {
        if (code == null) {
            return false;
        }
        for (IEnum en : ens) {
            if (equalsVal(en, code)) {
                return true;
            }
        }
        return false;
    }

    public static IEnum getElementByCode(IEnum[] ens, Object code) {

        if (code == null) {
            return null;
        }
        for (IEnum en : ens) {
            if (equalsVal(en, code)) {
                return en;
            }
        }
        return null;

    }

    public static String getDescByCode(IEnum[] ens, Object code) {

        if (code == null) {
            return null;
        }
        for (IEnum en : ens) {
            if (equalsVal(en, code)) {
                return en.getDesc();
            }
        }
        return null;

    }

}