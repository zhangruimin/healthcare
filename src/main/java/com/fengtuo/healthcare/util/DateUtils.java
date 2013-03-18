package com.fengtuo.healthcare.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/23/13
 * Time: 12:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class DateUtils {
   private static final String PATTERN = "yyyy-MM-dd hh:mm:ss";

    public static Date parse(String dateString){
        try {
            return new SimpleDateFormat(PATTERN).parse(dateString);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String format(Date date){
        return new SimpleDateFormat(PATTERN).format(date);
    }
}
