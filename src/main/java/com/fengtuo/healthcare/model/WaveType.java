package com.fengtuo.healthcare.model;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/18/13
 * Time: 9:07 PM
 * To change this template use File | Settings | File Templates.
 */
public enum WaveType {
    ECG, BO, BREATH;

    public static int getDataByteNumber(WaveType type) {
        switch (type){
            case ECG:
                return 120;
            case BO:
                return 30;
            case BREATH:
                return 10;
        }
        return 0;
    }

    public static byte getDefaultValue(WaveType type) {
        switch (type){
            case ECG:
                return (byte)150;
            case BO:
                return 20;
        }
        return 0;
    }
}
