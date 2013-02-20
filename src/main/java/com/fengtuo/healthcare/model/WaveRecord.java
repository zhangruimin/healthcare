package com.fengtuo.healthcare.model;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/4/13
 * Time: 9:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class WaveRecord extends HealthRecord {
    private WaveType waveType;

    public WaveRecord(String deviceId) {
        super(deviceId);
    }

    public WaveType getWaveType() {
        return waveType;
    }

    public void setWaveType(WaveType waveType) {
        this.waveType = waveType;
    }
}
