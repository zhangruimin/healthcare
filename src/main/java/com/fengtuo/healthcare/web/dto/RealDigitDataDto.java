package com.fengtuo.healthcare.web.dto;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 3/18/13
 * Time: 9:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class RealDigitDataDto {
    private String temperature;
    private String heartRate;
    private String bloodOxygen;
    private String PR;
    private String resp;
    private String bs;

    public String getBs() {
        return bs;
    }

    public String getResp() {
        return resp;
    }

    public String getPR() {
        return PR;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(String heartRate) {
        this.heartRate = heartRate;
    }

    public String getBloodOxygen() {
        return bloodOxygen;
    }

    public void setBloodOxygen(String bloodOxygen) {
        this.bloodOxygen = bloodOxygen;
    }

    public void setPR(String PR) {
        this.PR = PR;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }
}
