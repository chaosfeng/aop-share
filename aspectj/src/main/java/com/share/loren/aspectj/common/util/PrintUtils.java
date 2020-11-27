package com.share.loren.aspectj.common.util;

/**
 * @author lorenl
 * @date 11/26/2020
 */
public class PrintUtils {

    public static void print(Object o) {
        if (o == null) {
            return;
        }
        System.out.println(o);
        System.out.println();
    }

}
