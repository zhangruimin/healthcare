package com.fengtuo.healthcare.extractor;

import com.fengtuo.healthcare.builder.PacketStreamBuilder;
import com.fengtuo.healthcare.model.*;
import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/19/13
 * Time: 8:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class HealthRecordExtractorTest {
//    @Test
//    public void should_extract_one_digit_data_type_record_from_bytes_steam() throws Exception {
//        byte[] header = {(byte)0xA0, (byte)0x55};
//        byte[] signalStrength = {(byte)0x23};
//        byte[] deviceType = {0, 1};
//        byte[] deviceStatus = {0};
//        byte[] statusParam = {0};
//        byte[] deviceId = {0, 0, 0, 1};
//        byte[] date = {12, 2, 31, 23, 59, 59};
//        byte[] validBytes = {1, 2};
//        byte[] dataTypes = {0, 1};
//        byte[] digitData = {67};
//        byte[] waveTypes = {0};
//        byte[] waveData = {};
//
//        byte[] streamBytes = new PacketStreamBuilder(header,
//                signalStrength,
//                deviceType,
//                deviceStatus,
//                statusParam,
//                deviceId,
//                date,
//                validBytes,
//                dataTypes,
//                digitData,
//                waveTypes,
//                waveData)
//                .build();
//
//        Packet packet = HealthRecordExtractor.extract(streamBytes);
//
//        assertThat(packet).isNotNull();
//        List<DigitRecord> digitRecords = packet.getDigitRecords();
//        assertThat(digitRecords.size()).isEqualTo(1);
//        DigitRecord digitRecord = digitRecords.get(0);
//        assertThat(digitRecord.getDeviceType()).isEqualTo(DeviceType.Monitor);
//        assertThat(digitRecord.getDeviceStatus()).isEqualTo(DeviceStatus.Normal);
//        assertThat(digitRecord.getDeviceId()).isEqualTo(DeviceIdExtractor.extract(deviceId));
//        assertThat(digitRecord.getTimestamp()).isEqualTo(TimeStampExtractor.extract(date));
//        assertThat(digitRecord.getDataType()).isEqualTo(DataType.HR);
//        assertThat(digitRecord.getData()).isEqualTo(digitData);
//    }
//
//    @Test
//    public void should_extract_multiple_digit_data_type_records_from_bytes_steam() throws Exception {
//        byte[] streamBytes = new PacketStreamBuilder()
//                .withDigitDataTypes(new byte[]{Byte.valueOf("00000000", 2), (byte)(Integer.valueOf("10101111", 2).intValue())})
//                .withDigitData(new byte[]{67, 69, 98, 36, 50, 18, 4, 70})
//                .build();
//
//        Packet packet = HealthRecordExtractor.extract(streamBytes);
//
//        List<DigitRecord> digitRecords = packet.getDigitRecords();
//        assertThat(digitRecords.size()).isEqualTo(6);
//        DigitRecord HRRecord = digitRecords.get(0);
//        assertThat(HRRecord.getDataType()).isEqualTo(DataType.HR);
//        assertThat(HRRecord.getData()).isEqualTo(new byte[]{67});
//
//        DigitRecord PRRecord = digitRecords.get(1);
//        assertThat(PRRecord.getDataType()).isEqualTo(DataType.PR);
//        assertThat(PRRecord.getData()).isEqualTo(new byte[]{69});
//
//        DigitRecord SPO2Record = digitRecords.get(2);
//        assertThat(SPO2Record.getDataType()).isEqualTo(DataType.SPO2);
//        assertThat(SPO2Record.getData()).isEqualTo(new byte[]{98});
//
//        DigitRecord digitRecord = digitRecords.get(3);
//        assertThat(digitRecord.getDataType()).isEqualTo(DataType.TEMP1);
//        assertThat(digitRecord.getData()).isEqualTo(new byte[]{36, 50});
//
//        DigitRecord RESPRecord = digitRecords.get(4);
//        assertThat(RESPRecord.getDataType()).isEqualTo(DataType.RESP);
//        assertThat(RESPRecord.getData()).isEqualTo(new byte[]{18});
//
//        DigitRecord BSRecord = digitRecords.get(5);
//        assertThat(BSRecord.getDataType()).isEqualTo(DataType.BS);
//        assertThat(BSRecord.getData()).isEqualTo(new byte[]{4, 70});
//    }
//
//    @Test
//    public void should_extract_one_wave_type_record_from_bytes_steam() throws Exception {
//        byte[] header = {(byte)0xA0, (byte)0x55};
//        byte[] signalStrength = {(byte)0x23};
//        byte[] deviceType = {0, 1};
//        byte[] deviceStatus = {0};
//        byte[] statusParam = {0};
//        byte[] deviceId = {0, 0, 0, 1};
//        byte[] date = {12, 2, 31, 23, 59, 59};
//        byte[] validBytes = {1, 2};
//        byte[] dataTypes = {0, 1};
//        byte[] digitData = {67};
//        byte[] waveTypes = {1};
//        byte[] waveData = {(byte)0x40, (byte)0x48, (byte)0x50, (byte)0x54, (byte)0x58, (byte)0x50, (byte)0x48, (byte)0x40, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x3c, (byte)0x40, (byte)0x30, (byte)0x28, (byte)0x20, (byte)0x38, (byte)0xf4, (byte)0xf8, (byte)0xd0, (byte)0xa8, (byte)0x80, (byte)0x00, (byte)0x08, (byte)0x10, (byte)0x20, (byte)0x30, (byte)0x34, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x40, (byte)0x48, (byte)0x54, (byte)0x60, (byte)0x68, (byte)0x70, (byte)0x74, (byte)0x78, (byte)0x70, (byte)0x68, (byte)0x5c, (byte)0x50, (byte)0x4c, (byte)0x48, (byte)0x44, (byte)0x40, (byte)0x3c, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x40, (byte)0x38, (byte)0x40, (byte)0x48, (byte)0x50, (byte)0x54, (byte)0x58, (byte)0x50, (byte)0x48, (byte)0x40, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x3c, (byte)0x40, (byte)0x30, (byte)0x28, (byte)0x20, (byte)0x38, (byte)0xf4, (byte)0xf8, (byte)0xd0, (byte)0xa8, (byte)0x80, (byte)0x00, (byte)0x08, (byte)0x10, (byte)0x20, (byte)0x30, (byte)0x34, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x40, (byte)0x48, (byte)0x54, (byte)0x60, (byte)0x68, (byte)0x70, (byte)0x74, (byte)0x78, (byte)0x70, (byte)0x68, (byte)0x5c, (byte)0x50, (byte)0x4c, (byte)0x48, (byte)0x44, (byte)0x40, (byte)0x3c, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x40, (byte)0x38, (byte)0x40, (byte)0x48, (byte)0x50, (byte)0x54, (byte)0x58, (byte)0x50, (byte)0x48, (byte)0x40, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x3c, (byte)0x40, (byte)0x30, (byte)0x28, (byte)0x20, (byte)0x38, (byte)0xf4, (byte)0xf8, (byte)0xd0, (byte)0xa8, (byte)0x80, (byte)0x00, (byte)0x08, (byte)0x10, (byte)0x20, (byte)0x30, (byte)0x34, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x40, (byte)0x48, (byte)0x54, (byte)0x60, (byte)0x68, (byte)0x70, (byte)0x74, (byte)0x78, (byte)0x70, (byte)0x68, (byte)0x5c, (byte)0x50, (byte)0x4c, (byte)0x48, (byte)0x44, (byte)0x40, (byte)0x3c, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x40, (byte)0x38, (byte)0x40, (byte)0x48, (byte)0x50, (byte)0x54, (byte)0x58, (byte)0x50, (byte)0x48, (byte)0x40, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x3c, (byte)0x40, (byte)0x30, (byte)0x28, (byte)0x20, (byte)0x38, (byte)0xf4, (byte)0xf8, (byte)0xd0, (byte)0xa8, (byte)0x80, (byte)0x00, (byte)0x08, (byte)0x10, (byte)0x20, (byte)0x30, (byte)0x34, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x40, (byte)0x48, (byte)0x19};
//
//        byte[] streamBytes = new PacketStreamBuilder(header,
//                signalStrength,
//                deviceType,
//                deviceStatus,
//                statusParam,
//                deviceId,
//                date,
//                validBytes,
//                dataTypes,
//                digitData,
//                waveTypes,
//                waveData)
//                .build();
//
//        Packet packet = HealthRecordExtractor.extract(streamBytes);
//
//        List<WaveRecord> waveRecords = packet.getWaveRecords();
//        assertThat(waveRecords.size()).isEqualTo(1);
//        WaveRecord waveRecord = waveRecords.get(0);
//        assertThat(waveRecord.getDeviceType()).isEqualTo(DeviceType.Monitor);
//        assertThat(waveRecord.getDeviceStatus()).isEqualTo(DeviceStatus.Normal);
//        assertThat(waveRecord.getTimestamp()).isEqualTo(TimeStampExtractor.extract(date));
//        assertThat(waveRecord.getDeviceId()).isEqualTo(DeviceIdExtractor.extract(deviceId));
//        assertThat(waveRecord.getWaveType()).isEqualTo(WaveType.ECG);
//        assertThat(waveRecord.getData()).isEqualTo(waveData);
//    }
//
//    @Test
//    public void should_extract_multiple_wave_type_records_from_bytes_steam() throws Exception {
//        byte[] waveTypes = {3};
//        byte[] ECGwaveData = {(byte)0x40, (byte)0x48, (byte)0x50, (byte)0x54, (byte)0x58, (byte)0x50, (byte)0x48, (byte)0x40, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x3c, (byte)0x40, (byte)0x30, (byte)0x28, (byte)0x20, (byte)0x38, (byte)0xf4, (byte)0xf8, (byte)0xd0, (byte)0xa8, (byte)0x80, (byte)0x00, (byte)0x08, (byte)0x10, (byte)0x20, (byte)0x30, (byte)0x34, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x40, (byte)0x48, (byte)0x54, (byte)0x60, (byte)0x68, (byte)0x70, (byte)0x74, (byte)0x78, (byte)0x70, (byte)0x68, (byte)0x5c, (byte)0x50, (byte)0x4c, (byte)0x48, (byte)0x44, (byte)0x40, (byte)0x3c, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x40, (byte)0x38, (byte)0x40, (byte)0x48, (byte)0x50, (byte)0x54, (byte)0x58, (byte)0x50, (byte)0x48, (byte)0x40, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x3c, (byte)0x40, (byte)0x30, (byte)0x28, (byte)0x20, (byte)0x38, (byte)0xf4, (byte)0xf8, (byte)0xd0, (byte)0xa8, (byte)0x80, (byte)0x00, (byte)0x08, (byte)0x10, (byte)0x20, (byte)0x30, (byte)0x34, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x40, (byte)0x48, (byte)0x54, (byte)0x60, (byte)0x68, (byte)0x70, (byte)0x74, (byte)0x78, (byte)0x70, (byte)0x68, (byte)0x5c, (byte)0x50, (byte)0x4c, (byte)0x48, (byte)0x44, (byte)0x40, (byte)0x3c, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x40, (byte)0x38, (byte)0x40, (byte)0x48, (byte)0x50, (byte)0x54, (byte)0x58, (byte)0x50, (byte)0x48, (byte)0x40, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x3c, (byte)0x40, (byte)0x30, (byte)0x28, (byte)0x20, (byte)0x38, (byte)0xf4, (byte)0xf8, (byte)0xd0, (byte)0xa8, (byte)0x80, (byte)0x00, (byte)0x08, (byte)0x10, (byte)0x20, (byte)0x30, (byte)0x34, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x40, (byte)0x48, (byte)0x54, (byte)0x60, (byte)0x68, (byte)0x70, (byte)0x74, (byte)0x78, (byte)0x70, (byte)0x68, (byte)0x5c, (byte)0x50, (byte)0x4c, (byte)0x48, (byte)0x44, (byte)0x40, (byte)0x3c, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x40, (byte)0x38, (byte)0x40, (byte)0x48, (byte)0x50, (byte)0x54, (byte)0x58, (byte)0x50, (byte)0x48, (byte)0x40, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x3c, (byte)0x40, (byte)0x30, (byte)0x28, (byte)0x20, (byte)0x38, (byte)0xf4, (byte)0xf8, (byte)0xd0, (byte)0xa8, (byte)0x80, (byte)0x00, (byte)0x08, (byte)0x10, (byte)0x20, (byte)0x30, (byte)0x34, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x38, (byte)0x40, (byte)0x48, (byte)0x19};
//        byte[] BOwaveData = {(byte)32, (byte)0x4b, (byte)0x64, (byte)0x7d, (byte)0x96, (byte)0xaf, (byte)0xc8, (byte)0xe1, (byte)0xe6, (byte)0xeb, (byte)0xf0, (byte)0xee, (byte)0xec, (byte)0xe9, (byte)0xdf, (byte)0xd5, (byte)0xcb, (byte)0xc8, (byte)0xc5, (byte)0xcd, (byte)0xd2, (byte)0xd5, (byte)0xd5, (byte)0xd7, (byte)0xd7, (byte)0xd5, (byte)0xd5, (byte)0xd2, (byte)0xd2, (byte)0xcb, (byte)0xc4, (byte)0xbd, (byte)0xb6, (byte)0xaf, (byte)0xa8, (byte)0xa1, (byte)0x9a, (byte)0x93, (byte)0x8c, (byte)0x85, (byte)0x7e, (byte)0x77, (byte)0x70, (byte)0x69, (byte)0x62, (byte)0x5b, (byte)0x54, (byte)0x4d, (byte)0x46, (byte)0x3f, (byte)0x38, (byte)0x31, (byte)0x2a, (byte)0x23, (byte)0x1c, (byte)0x15, (byte)0x0e, (byte)0x07, (byte)0x00, (byte)0xff};
//
//        byte[] streamBytes = new PacketStreamBuilder()
//                .withWaveTypes(waveTypes)
//                .withWaveData(ArrayUtils.addAll(ECGwaveData, BOwaveData))
//                .build();
//
//        Packet packet = HealthRecordExtractor.extract(streamBytes);
//
//        List<WaveRecord> waveRecords = packet.getWaveRecords();
//        assertThat(waveRecords.size()).isEqualTo(2);
//        WaveRecord ECGWaveRecord = waveRecords.get(0);
//        assertThat(ECGWaveRecord.getWaveType()).isEqualTo(WaveType.ECG);
////        assertThat(ECGWaveRecord.getData()).isEqualTo(ECGwaveData);
//
//        WaveRecord BWWaveRecord = waveRecords.get(1);
//        assertThat(BWWaveRecord.getWaveType()).isEqualTo(WaveType.BO);
////        assertThat(BWWaveRecord.getData()).isEqualTo(BOwaveData);
//    }
}
