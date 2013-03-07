package com.fengtuo.healthcare.util;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/19/13
 * Time: 10:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class CollectionUtils {
    public static byte[] get(byte[] array, int offset, int length) {
        byte[] result = new byte[length];
        System.arraycopy(array, offset, result, 0, length);
        return result;
    }

    public static byte[] toPrimitive(Byte[] array) {
        byte[] result = new byte[array.length];
        for(int i=0;i<result.length;i++){
            result[i] = array[i];
        }
        return result;
    }

    public static Byte[] toWrappedTypes(byte[] array) {
        Byte[] result = new Byte[array.length];
        for(int i=0;i<result.length;i++){
            result[i] = array[i];
        }
        return result;
    }

}
