package com.fengtuo.healthcare.model;

import org.springframework.data.annotation.Id;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/4/13
 * Time: 9:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class WaveRecord extends HealthRecord {
    private WaveType waveType;
    
    @Id
    private String id;

    public WaveRecord(String deviceId) {
        super(deviceId);
    }

    public WaveRecord() {
    }

    public WaveType getWaveType() {
        return waveType;
    }

    public void setWaveType(WaveType waveType) {
        this.waveType = waveType;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
