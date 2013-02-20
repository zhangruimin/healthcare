package com.fengtuo.healthcare.model;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/4/13
 * Time: 9:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class DigitRecord extends HealthRecord {
    private DataType dataType;

    public DigitRecord(String deviceId) {
        super(deviceId);
    }

    public DigitRecord() {
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }
}
