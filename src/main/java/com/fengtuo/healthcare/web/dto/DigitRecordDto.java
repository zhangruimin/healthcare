package com.fengtuo.healthcare.web.dto;

import com.fengtuo.healthcare.model.DataType;
import com.fengtuo.healthcare.model.DigitRecord;
import com.fengtuo.healthcare.model.WaveRecord;
import com.fengtuo.healthcare.util.DateUtils;
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
    private String timestamp;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
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
        digitRecordDto.setData(digitRecord.getDataString());
        digitRecordDto.setDeviceId(digitRecord.getDeviceId());
        digitRecordDto.setTimestamp(DateUtils.format(digitRecord.getTimestamp()));
        return digitRecordDto;
    }
}
