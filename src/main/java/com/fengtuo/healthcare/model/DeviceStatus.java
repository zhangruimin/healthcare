package com.fengtuo.healthcare.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/18/13
 * Time: 9:02 PM
 * To change this template use File | Settings | File Templates.
 */
public enum DeviceStatus {
    Normal;


    private static Map<Integer, DeviceStatus> map = new HashMap<Integer, DeviceStatus>();

    public static DeviceStatus getType(int num) {
        return map.get(num);
    }

    static {
        map.put(0, Normal);
    }
}
