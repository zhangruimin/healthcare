package com.fengtuo.healthcare.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/19/13
 * Time: 9:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class Packet {
    private List<DigitRecord> digitRecords = new ArrayList<DigitRecord>();
    private List<WaveRecord> waveRecords = new ArrayList<WaveRecord>();
    private String deviceId;

    public Packet() {
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public List<DigitRecord> getDigitRecords() {
        return digitRecords;
    }

    public void setDigitRecords(List<DigitRecord> digitRecords) {
        this.digitRecords = digitRecords;
    }

    public List<WaveRecord> getWaveRecords() {
        return waveRecords;
    }

    public void setWaveRecords(List<WaveRecord> waveRecords) {
        this.waveRecords = waveRecords;
    }

    public void addRecord(DigitRecord digitRecord) {
        digitRecords.add(digitRecord);
    }

    public void addRecord(WaveRecord waveRecord) {
        waveRecords.add(waveRecord);
    }

    public void initRecordUser(String userId) {
        for(DigitRecord digitRecord:digitRecords){
            digitRecord.setUserId(userId);
        }

        for(WaveRecord waveRecord:waveRecords){
            waveRecord.setUserId(userId);
        }
    }
}
