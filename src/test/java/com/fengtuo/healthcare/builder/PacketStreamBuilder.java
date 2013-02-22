package com.fengtuo.healthcare.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/21/13
 * Time: 8:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class PacketStreamBuilder {
    private Byte[] header = {0xa, 0};
    private Byte[] signalStrength = {127};
    private Byte[] deviceType = {0, 1};
    private Byte[] deviceStatus = {0};
    private Byte[] statusParam = {0};
    private Byte[] deviceId = {1, 2, 3, 4};
    private Byte[] date = {1, 2, 3, 4, 5, 6};
    private Byte[] validBytes = {1, 2};
    private Byte[] dateType = {0, 1};
    private Byte[] digitData = {12};
    private Byte[] waveType = {1};
    private Byte[] waveData = {1};

    public PacketStreamBuilder(Byte[] header, Byte[] signalStrength, Byte[] deviceType, Byte[] deviceStatus, Byte[] statusParam, Byte[] deviceId, Byte[] date, Byte[] validBytes, Byte[] dateType, Byte[] digitData, Byte[] waveType, Byte[] waveData) {
        this.header = header;
        this.signalStrength = signalStrength;
        this.deviceType = deviceType;
        this.deviceStatus = deviceStatus;
        this.statusParam = statusParam;
        this.deviceId = deviceId;
        this.date = date;
        this.validBytes = validBytes;
        this.dateType = dateType;
        this.digitData = digitData;
        this.waveType = waveType;
        this.waveData = waveData;
    }

    public PacketStreamBuilder() {
    }

    public byte[] build(){
           return  getPacketStream(header, signalStrength, deviceType, deviceStatus, statusParam, deviceId, date, validBytes, dateType, digitData, waveType, waveData);
    }

    private byte[] getPacketStream(Byte[] header, Byte[] signalStrength, Byte[] deviceType, Byte[] deviceStatus, Byte[] statusParam, Byte[] deviceId, Byte[] date, Byte[] validBytes, Byte[] dateType, Byte[] digitData, Byte[] waveType, Byte[] waveData) {
        List<Byte> stream = new ArrayList<Byte>();
        stream.addAll(Arrays.asList(header));
        stream.addAll(Arrays.asList(signalStrength));
        stream.addAll(Arrays.asList(deviceType));
        stream.addAll(Arrays.asList(deviceStatus));
        stream.addAll(Arrays.asList(statusParam));
        stream.addAll(Arrays.asList(deviceId));
        stream.addAll(Arrays.asList(date));
        stream.addAll(Arrays.asList(validBytes));
        stream.addAll(Arrays.asList(dateType));
        stream.addAll(Arrays.asList(digitData));
        stream.addAll(Arrays.asList(waveType));
        stream.addAll(Arrays.asList(waveData));

        byte[] streamBytes = new byte[stream.size()];
        for (int i = 0; i < streamBytes.length; i++) {
            streamBytes[i] = stream.get(i);
        }
        return streamBytes;
    }
}
