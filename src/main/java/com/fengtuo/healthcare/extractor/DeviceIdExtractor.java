package com.fengtuo.healthcare.extractor;

import com.fengtuo.healthcare.util.NumUtils;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/19/13
 * Time: 10:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class DeviceIdExtractor {
    public static String extract(byte[] deviceIdData){
        int h1 = ((int)deviceIdData[0]) << 24;
        int h2 = ((int)deviceIdData[1]) << 16;
        int h3 = ((int)deviceIdData[2]) << 8;
        int result = h1 + h2 + h3 + NumUtils.toInt(deviceIdData[3]);

        return String.valueOf(result);
    }
}
