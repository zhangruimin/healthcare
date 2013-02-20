package com.fengtuo.healthcare.service;

import com.fengtuo.healthcare.model.*;
import com.fengtuo.healthcare.util.CollectionUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
    @Test
    public void should_extract_health_records_from_bytes_steam() throws Exception {
        Byte[] header = {0xa, 0};
        Byte[] signalStrength = {127};
        Byte[] deviceType = {0, 1};
        Byte[] deviceStatus = {0};
        Byte[] statusParam = {0};
        Byte[] deviceId = {1, 2, 3, 4};
        Byte[] date = {1, 2, 3, 4, 5, 6};
        Byte[] validBytes = {1, 2};
        Byte[] dateType = {0, 1};
        Byte[] digitData = {12};
        Byte[] waveType = {1};
        Byte[] waveData = {1};

        byte[] streamBytes = getPacketStream(header, signalStrength, deviceType, deviceStatus, statusParam, deviceId, date, validBytes, dateType, digitData, waveType, waveData);

        Packet packet = HealthRecordExtractor.extract(streamBytes);

        assertThat(packet).isNotNull();
        List<DigitRecord> digitRecords = packet.getDigitRecords();
        assertThat(digitRecords.size()).isEqualTo(1);
        DigitRecord digitRecord = digitRecords.get(0);
        assertThat(digitRecord.getDeviceType()).isEqualTo(DeviceType.Monitor);
        assertThat(digitRecord.getDeviceStatus()).isEqualTo(DeviceStatus.Normal);
        assertThat(digitRecord.getDeviceId()).isEqualTo(DeviceIdExtractor.extract(CollectionUtils.toPrimitive(deviceId)));
//        assertThat(digitRecord.getTimeStamp()).isEqualTo();
        assertThat(digitRecord.getDataType()).isEqualTo(DataType.HR);
        assertThat(digitRecord.getData()).isEqualTo(CollectionUtils.toPrimitive(digitData));
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
