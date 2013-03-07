package com.fengtuo.healthcare.util;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 3/7/13
 * Time: 10:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class NumUtils {

    public static int toInt(byte[] array) {
        if(array.length==2){
            return toInt(array[1])*256+toInt(array[1]);
        }

        if(array.length==1){
            return toInt(array[0]);
        }

        return 0;
    }

    public static int toInt(byte b) {
        return b >= 0 ? b : b + 256;
    }
}
