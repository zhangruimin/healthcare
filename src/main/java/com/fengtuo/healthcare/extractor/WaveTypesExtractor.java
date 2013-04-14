package com.fengtuo.healthcare.extractor;

import com.fengtuo.healthcare.model.WaveType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/23/13
 * Time: 1:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class WaveTypesExtractor {
    private WaveType[] waveTypes;
    private int waveDataStartIndex;

    public WaveTypesExtractor(byte waveTypeByte, int waveDataStartIndex) {
        this.waveDataStartIndex = waveDataStartIndex;
        extractTypes(waveTypeByte);
    }

    private void extractTypes(byte waveTypeByte) {
        List<WaveType> types = new ArrayList<WaveType>();
        if ((waveTypeByte & 1) != 0) {
            types.add(WaveType.ECG);
        }

        if ((waveTypeByte & 2) != 0) {
            types.add(WaveType.BO);
        }

        if ((waveTypeByte & 4) != 0) {
            types.add(WaveType.BREATH);
        }

        waveTypes = types.toArray(new WaveType[0]);
    }

    public WaveType[] getWaveTypes() {
        return waveTypes;
    }

    public int getStartIndex(WaveType type) {
        int index = waveDataStartIndex;
        for (WaveType current : waveTypes) {
            if (current.equals(type)) {
                return index;
            }
            index += WaveType.getDataByteNumber(current);
        }
        // should never reach here
        return index;
    }
}
