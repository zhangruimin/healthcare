package com.fengtuo.healthcare.extractor;

import com.fengtuo.healthcare.model.*;
import com.fengtuo.healthcare.util.CollectionUtils;

import java.util.Date;

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
        String deviceId = DeviceIdExtractor.extract(CollectionUtils.get(data, 7, 4));
        Date timeStamp = TimeStampExtractor.extract(CollectionUtils.get(data, 11, 6));

        byte[] digitDataTypeBytes = CollectionUtils.get(data, 19, 2);
        DigitDataTypesExtractor digitDataTypeExtractor = new DigitDataTypesExtractor(digitDataTypeBytes);
        DataType[] digitDataTypes = digitDataTypeExtractor.getDataTypes();
        for (DataType type : digitDataTypes) {
            DigitRecord digitRecord = new DigitRecord();
            digitRecord.setDeviceType(deviceType);
            digitRecord.setDeviceStatus(deviceStatus);
            digitRecord.setDeviceId(deviceId);
            digitRecord.setDataType(type);
            digitRecord.setData(CollectionUtils.get(data, digitDataTypeExtractor.getStartIndex(type), DataType.getDataByteNumber(type)));
            digitRecord.setTimeStamp(timeStamp);
            packet.addRecord(digitRecord);
        }

        WaveTypesExtractor waveTypesExtractor = new WaveTypesExtractor(data[digitDataTypeExtractor.getIndexAfterDigitData()], digitDataTypeExtractor.getIndexAfterDigitData() + 1);
        WaveType[] waveTypes = waveTypesExtractor.getWaveTypes();

        for (WaveType type : waveTypes) {
            WaveRecord waveRecord = new WaveRecord();
            waveRecord.setDeviceType(deviceType);
            waveRecord.setDeviceStatus(deviceStatus);
            waveRecord.setDeviceId(deviceId);
            waveRecord.setWaveType(type);
            waveRecord.setData(CollectionUtils.get(data, waveTypesExtractor.getStartIndex(type), WaveType.getDataByteNumber(type)));
            waveRecord.setTimeStamp(timeStamp);
            packet.addRecord(waveRecord);
        }
        return packet;
    }
}
