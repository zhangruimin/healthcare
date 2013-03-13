package com.fengtuo.healthcare.web.dto;

import com.fengtuo.healthcare.model.DataType;
import com.fengtuo.healthcare.model.DigitRecord;
import com.fengtuo.healthcare.model.WaveRecord;
import com.fengtuo.healthcare.util.NumUtils;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/28/13
 * Time: 10:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class DigitRecordDto {
    private String data = "Not Set";
    private String deviceId;
    private Date timestamp;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public static DigitRecordDto from(DigitRecord digitRecord) {
        DigitRecordDto digitRecordDto = new DigitRecordDto();
        if (DataType.TEMP1.equals(digitRecord.getDataType())) {
            digitRecordDto.setData(NumUtils.toInt(digitRecord.getData()[0]) + "." + NumUtils.toInt(digitRecord.getData()[1]));
        } else {
            digitRecordDto.setData(String.valueOf(NumUtils.toInt(digitRecord.getData()[0])));
        }
        digitRecordDto.setDeviceId(digitRecord.getDeviceId());
        digitRecordDto.setTimestamp(digitRecord.getTimestamp());
        return digitRecordDto;
    }
}
