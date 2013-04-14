package com.fengtuo.healthcare.web.dto;

import com.fengtuo.healthcare.model.WaveRecord;
import com.fengtuo.healthcare.util.NumUtils;
import org.apache.commons.lang.ArrayUtils;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/28/13
 * Time: 10:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class WaveRecordDto {
    private int[] data;
    private Date timestamp;

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public static WaveRecordDto from(List<WaveRecord> waveRecords) {
        byte[] data = new byte[0];
        for (WaveRecord waveRecord : waveRecords) {
            data = ArrayUtils.addAll(data, waveRecord.getData());
        }
        WaveRecordDto waveRecordDto = new WaveRecordDto();
        waveRecordDto.data = toIntArray(data);
        waveRecordDto.timestamp = waveRecords.get(waveRecords.size()-1).getTimestamp();
        return waveRecordDto;
    }

    private static int[] toIntArray(byte[] data) {
        int[] result = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = NumUtils.toInt(data[i]);
        }
        return result;
    }
}
