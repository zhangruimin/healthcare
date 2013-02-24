package com.fengtuo.healthcare.model;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/18/13
 * Time: 9:07 PM
 * To change this template use File | Settings | File Templates.
 */
public enum WaveType {
    ECG, BO;

    public static int getDataByteNumber(WaveType type) {
        switch (type){
            case ECG:
                return 250;
            case BO:
                return 60;
        }
        return 0;
    }
}
