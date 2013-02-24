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
    HR, PR, SPO2, TEMP1, TEMP2, RESP, NIBP, BS, BKB, BUA, BMI, CI, CPFI, BMR;

    public static int getDataByteNumber(DataType type){
        if(type.equals(TEMP1)||type.equals(TEMP2)||type.equals(BS)){
            return 2;
        }
        return 1;
    }
}
