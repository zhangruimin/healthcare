package com.fengtuo.healthcare.extractor;

import com.fengtuo.healthcare.model.DataType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/23/13
 * Time: 1:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class DigitDataTypesExtractor {
    private static final int DIGIT_DATA_START_INDEX = 21;

    private DataType[] dataTypes;

    public int getIndexAfterDigitData() {
        return indexAfterDigitData;
    }

    private int indexAfterDigitData = DIGIT_DATA_START_INDEX;

    public DigitDataTypesExtractor(byte[] dateTypeBytes) {
        extractTypes(dateTypeBytes);
        for (DataType current : dataTypes) {
            indexAfterDigitData += DataType.getDataByteNumber(current);
        }
    }

    private void extractTypes(byte[] dateTypeBytes) {
        List<DataType> types = new ArrayList<DataType>();
        byte secondByte = dateTypeBytes[1];
        if ((secondByte & 1) != 0) {
            types.add(DataType.HR);
        }

        if ((secondByte & 2) != 0) {
            types.add(DataType.PR);
        }

        if ((secondByte & 4) != 0) {
            types.add(DataType.SPO2);
        }

        if ((secondByte & 8) != 0) {
            types.add(DataType.TEMP1);
        }

        if ((secondByte & 16) != 0) {
            types.add(DataType.TEMP2);
        }

        if ((secondByte & 32) != 0) {
            types.add(DataType.RESP);
        }

        if ((secondByte & 64) != 0) {
            types.add(DataType.NIBP);
        }

        if ((secondByte & 128) != 0) {
            types.add(DataType.BS);
        }

        byte firstByte = dateTypeBytes[0];

        if ((firstByte & 1) != 0) {
            types.add(DataType.BKB);
        }

        if ((firstByte & 2) != 0) {
            types.add(DataType.BUA);
        }

        if ((firstByte & 4) != 0) {
            types.add(DataType.BMI);
        }

        if ((firstByte & 8) != 0) {
            types.add(DataType.CI);
        }

        if ((firstByte & 16) != 0) {
            types.add(DataType.CPFI);
        }

        if ((firstByte & 1) != 0) {
            types.add(DataType.BMR);
        }

        dataTypes = types.toArray(new DataType[0]);
    }

    public DataType[] getDataTypes() {
        return dataTypes;
    }

    public int getStartIndex(DataType type) {
        int index = DIGIT_DATA_START_INDEX;
        for (DataType current : dataTypes) {
            if (current.equals(type)) {
                return index;
            }
            index += DataType.getDataByteNumber(current);
        }
        // should never reach here
        return index;
    }
}
