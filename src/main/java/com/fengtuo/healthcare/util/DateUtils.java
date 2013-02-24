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
    public static Date parse(String dateString){
        try {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(dateString);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
