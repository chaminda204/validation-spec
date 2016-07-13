package com.chaminda.validation;


public class StringUtils {

    public static boolean isEmpty(Object str) {
        return (str == null || "".equals(str));
    }

    public static boolean isNotEmpty(String string){
        return !isEmpty(string);
    }
}
