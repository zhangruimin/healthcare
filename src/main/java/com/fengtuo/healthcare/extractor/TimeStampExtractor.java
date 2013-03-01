package com.fengtuo.healthcare.extractor;

import com.fengtuo.healthcare.util.DateUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/23/13
 * Time: 12:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class TimeStampExtractor {
    public static Date extract(byte[] bytes) {
        if(bytes.length!=6){
            throw new IllegalArgumentException("time stamp not correct");
        }

        return DateUtils.parse(String.format("%s-%s-%s %s:%s:%s",
                2000+bytes[0],bytes[1],bytes[2],bytes[3],bytes[4],bytes[5]));
    }

    public static byte[] toBytes(Date date) {
        byte[] bytes = new byte[6];
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return new byte[]{
                (byte)(calendar.get(Calendar.YEAR)-2000),
                (byte)(calendar.get(Calendar.MONTH)+1),
                (byte)calendar.get(Calendar.DATE),
                (byte)calendar.get(Calendar.HOUR_OF_DAY),
                (byte)calendar.get(Calendar.MINUTE),
                (byte)calendar.get(Calendar.SECOND)
        };
    }
}
