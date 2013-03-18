package com.fengtuo.healthcare.builder;

import com.fengtuo.healthcare.extractor.TimeStampExtractor;
import com.fengtuo.healthcare.util.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/21/13
 * Time: 8:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class PacketStreamBuilder {
    byte[] header = {(byte)0xA0, (byte)0x55};
    byte[] signalStrength = {(byte)0x23};
    byte[] deviceType = {0, 1};
    byte[] deviceStatus = {0};
    byte[] statusParam = {0};
    byte[] deviceId = {0, 0, 0, 1};
    byte[] date = {13, 2, 16, 23, 20, 35};
    byte[] validBytes = {1, 2};
    byte[] digitDataTypes = {Byte.valueOf("00000000", 2), (byte)(Integer.valueOf("10101111", 2).intValue())};
    byte[] digitData = {67, 69, 98, 36, 60, 18, 4, 70};
    byte[] waveTypes = {3};
    byte[] ECGwaveData = {(byte)0x40, (byte)0x48, (byte)0x50, (byte)0x54, (byte)0x58, (byte)0x50, (byte)0x48, (byte)0x40, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x3c, (byte)0x40, (byte)0x30, (byte)0x28, (byte)0x20, (byte)0x38, (byte)0xf4, (byte)0xf8, (byte)0xd0, (byte)0xa8, (byte)0x80, (byte)0x00, (byte)0x08, (byte)0x10, (byte)0x20, (byte)0x30, (byte)0x34, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x40, (byte)0x48, (byte)0x54, (byte)0x60, (byte)0x68, (byte)0x70, (byte)0x74, (byte)0x78, (byte)0x70, (byte)0x68, (byte)0x5c, (byte)0x50, (byte)0x4c, (byte)0x48, (byte)0x44, (byte)0x40, (byte)0x3c, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x40, (byte)0x38, (byte)0x40, (byte)0x48, (byte)0x50, (byte)0x54, (byte)0x58, (byte)0x50, (byte)0x48, (byte)0x40, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x3c, (byte)0x40, (byte)0x30, (byte)0x28, (byte)0x20, (byte)0x38, (byte)0xf4, (byte)0xf8, (byte)0xd0, (byte)0xa8, (byte)0x80, (byte)0x00, (byte)0x08, (byte)0x10, (byte)0x20, (byte)0x30, (byte)0x34, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x40, (byte)0x48, (byte)0x54, (byte)0x60, (byte)0x68, (byte)0x70, (byte)0x74, (byte)0x78, (byte)0x70, (byte)0x68, (byte)0x5c, (byte)0x50, (byte)0x4c, (byte)0x48, (byte)0x44, (byte)0x40, (byte)0x3c, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x40, (byte)0x38, (byte)0x40, (byte)0x48, (byte)0x50, (byte)0x54, (byte)0x58, (byte)0x50, (byte)0x48, (byte)0x40, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x3c, (byte)0x40, (byte)0x30, (byte)0x28, (byte)0x20, (byte)0x38, (byte)0xf4, (byte)0xf8, (byte)0xd0, (byte)0xa8, (byte)0x80, (byte)0x00, (byte)0x08, (byte)0x10, (byte)0x20, (byte)0x30, (byte)0x34, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x40, (byte)0x48, (byte)0x54, (byte)0x60, (byte)0x68, (byte)0x70, (byte)0x74, (byte)0x78, (byte)0x70, (byte)0x68, (byte)0x5c, (byte)0x50, (byte)0x4c, (byte)0x48, (byte)0x44, (byte)0x40, (byte)0x3c, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x40, (byte)0x38, (byte)0x40, (byte)0x48, (byte)0x50, (byte)0x54, (byte)0x58, (byte)0x50, (byte)0x48, (byte)0x40, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x3c, (byte)0x40, (byte)0x30, (byte)0x28, (byte)0x20, (byte)0x38, (byte)0xf4, (byte)0xf8, (byte)0xd0, (byte)0xa8, (byte)0x80, (byte)0x00, (byte)0x08, (byte)0x10, (byte)0x20, (byte)0x30, (byte)0x34, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x40, (byte)0x48, (byte)0x19};
    byte[] BOwaveData = {(byte)32, (byte)0x4b, (byte)0x64, (byte)0x7d, (byte)0x96, (byte)0xaf, (byte)0xc8, (byte)0xe1, (byte)0xe6, (byte)0xeb, (byte)0xf0, (byte)0xee, (byte)0xec, (byte)0xe9, (byte)0xdf, (byte)0xd5, (byte)0xcb, (byte)0xc8, (byte)0xc5, (byte)0xcd, (byte)0xd2, (byte)0xd5, (byte)0xd5, (byte)0xd7, (byte)0xd7, (byte)0xd5, (byte)0xd5, (byte)0xd2, (byte)0xd2, (byte)0xcb, (byte)0xc4, (byte)0xbd, (byte)0xb6, (byte)0xaf, (byte)0xa8, (byte)0xa1, (byte)0x9a, (byte)0x93, (byte)0x8c, (byte)0x85, (byte)0x7e, (byte)0x77, (byte)0x70, (byte)0x69, (byte)0x62, (byte)0x5b, (byte)0x54, (byte)0x4d, (byte)0x46, (byte)0x3f, (byte)0x38, (byte)0x31, (byte)0x2a, (byte)0x23, (byte)0x1c, (byte)0x15, (byte)0x0e, (byte)0x07, (byte)0x00, (byte)0xff};

    byte[] waveData = ArrayUtils.addAll(ECGwaveData, BOwaveData);

    public PacketStreamBuilder(byte[] header, byte[] signalStrength, byte[] deviceType, byte[] deviceStatus, byte[] statusParam, byte[] deviceId, byte[] date, byte[] validBytes, byte[] dateType, byte[] digitData, byte[] waveTypes, byte[] waveData) {
        this.header = header;
        this.signalStrength = signalStrength;
        this.deviceType = deviceType;
        this.deviceStatus = deviceStatus;
        this.statusParam = statusParam;
        this.deviceId = deviceId;
        this.date = date;
        this.validBytes = validBytes;
        this.digitDataTypes = dateType;
        this.digitData = digitData;
        this.waveTypes = waveTypes;
        this.waveData = waveData;
    }

    public PacketStreamBuilder() {
    }

    public byte[] build(){
           return  getPacketStream(header, signalStrength, deviceType, deviceStatus, statusParam, deviceId, date, validBytes, digitDataTypes, digitData, waveTypes, waveData);
    }

    private byte[] getPacketStream(byte[] header, byte[] signalStrength, byte[] deviceType, byte[] deviceStatus, byte[] statusParam, byte[] deviceId, byte[] date, byte[] validBytes, byte[] dateType, byte[] digitData, byte[] waveType, byte[] waveData) {
        List<Byte> stream = new ArrayList<Byte>();
        stream.addAll(Arrays.asList(CollectionUtils.toWrappedTypes(header)));
        stream.addAll(Arrays.asList(CollectionUtils.toWrappedTypes(signalStrength)));
        stream.addAll(Arrays.asList(CollectionUtils.toWrappedTypes(deviceType)));
        stream.addAll(Arrays.asList(CollectionUtils.toWrappedTypes(deviceStatus)));
        stream.addAll(Arrays.asList(CollectionUtils.toWrappedTypes(statusParam)));
        stream.addAll(Arrays.asList(CollectionUtils.toWrappedTypes(deviceId)));
        stream.addAll(Arrays.asList(CollectionUtils.toWrappedTypes(date)));
        stream.addAll(Arrays.asList(CollectionUtils.toWrappedTypes(validBytes)));
        stream.addAll(Arrays.asList(CollectionUtils.toWrappedTypes(dateType)));
        stream.addAll(Arrays.asList(CollectionUtils.toWrappedTypes(digitData)));
        stream.addAll(Arrays.asList(CollectionUtils.toWrappedTypes(waveType)));
        stream.addAll(Arrays.asList(CollectionUtils.toWrappedTypes(waveData)));

        byte[] streamBytes = new byte[stream.size()];
        for (int i = 0; i < streamBytes.length; i++) {
            streamBytes[i] = stream.get(i);
        }
        return streamBytes;
    }

    public PacketStreamBuilder withDigitDataTypes(byte[] dateTypes) {
        this.digitDataTypes = dateTypes;
        return this;
    }

    public PacketStreamBuilder withDigitData(byte[] data) {
        this.digitData = data;
        return this;
    }

    public PacketStreamBuilder withWaveTypes(byte[] waveTypes) {
        this.waveTypes = waveTypes;
        return this;
    }

    public PacketStreamBuilder withWaveData(byte[] waveData) {
        this.waveData = waveData;
        return this;
    }

    public PacketStreamBuilder withTimestamp(Date timestamp) {
        this.date = TimeStampExtractor.toBytes(timestamp);
        return this;
    }
}
