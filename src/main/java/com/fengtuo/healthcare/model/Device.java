package com.fengtuo.healthcare.model;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 3/13/13
 * Time: 9:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class Device {
    private String deviceId;
    private DeviceType deviceType;

    public Device(String deviceId, DeviceType deviceType) {
        this.deviceId = deviceId;
        this.deviceType = deviceType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }
}
