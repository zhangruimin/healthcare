package com.fengtuo.healthcare.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/18/13
 * Time: 9:04 PM
 * To change this template use File | Settings | File Templates.
 */
public enum DataType {
    HR;

    private static Map<Integer, DataType> map = new HashMap<Integer, DataType>();

    public static DataType getType(byte[] bytes) {
        return map.get((int)bytes[1]);
    }

    static {
        map.put(1, HR);
    }
}
