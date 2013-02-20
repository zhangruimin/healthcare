package com.fengtuo.healthcare.service;

import com.fengtuo.healthcare.model.*;
import com.fengtuo.healthcare.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/18/13
 * Time: 9:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class HealthRecordExtractor {
    public static Packet extract(byte[] data) {
        Packet packet = new Packet();
        DeviceType deviceType = DeviceType.getType(data[4]);
        DeviceStatus deviceStatus = DeviceStatus.getType(data[5]);
        DigitRecord digitRecord = new DigitRecord();
        digitRecord.setDeviceType(deviceType);
        digitRecord.setDeviceStatus(deviceStatus);
        digitRecord.setDeviceId(DeviceIdExtractor.extract(CollectionUtils.get(data, 7, 4)));
        digitRecord.setDataType(DataType.getType(CollectionUtils.get(data, 19, 2)));
        digitRecord.setData(CollectionUtils.get(data, 21, 1));
        packet.addRecord(digitRecord);
        return packet;
    }

}
