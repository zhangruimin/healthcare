package com.fengtuo.healthcare.extractor;

import com.fengtuo.healthcare.model.DataType;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/23/13
 * Time: 1:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class DigitDataTypeExtractorTest {

    private DigitDataTypesExtractor digitDataTypeExtractor;

    @Test
    public void should_extract_date_types() throws Exception {
        digitDataTypeExtractor = new DigitDataTypesExtractor(new byte[]{0, 1});
        assertThat(digitDataTypeExtractor.getDataTypes().length).isEqualTo(1);
        assertThat(digitDataTypeExtractor.getDataTypes()[0]).isEqualTo(DataType.HR);
    }

    @Test
    public void should_extract_multiple_date_types() throws Exception {
        digitDataTypeExtractor = new DigitDataTypesExtractor(new byte[]{(byte)0x3f, (byte)0xff});
        assertThat(digitDataTypeExtractor.getDataTypes().length).isEqualTo(14);
        assertThat(digitDataTypeExtractor.getDataTypes()[0]).isEqualTo(DataType.HR);
        assertThat(digitDataTypeExtractor.getDataTypes()[1]).isEqualTo(DataType.PR);
        assertThat(digitDataTypeExtractor.getDataTypes()[2]).isEqualTo(DataType.SPO2);
        assertThat(digitDataTypeExtractor.getDataTypes()[3]).isEqualTo(DataType.TEMP1);
        assertThat(digitDataTypeExtractor.getDataTypes()[4]).isEqualTo(DataType.TEMP2);
        assertThat(digitDataTypeExtractor.getDataTypes()[5]).isEqualTo(DataType.RESP);
        assertThat(digitDataTypeExtractor.getDataTypes()[6]).isEqualTo(DataType.NIBP);
        assertThat(digitDataTypeExtractor.getDataTypes()[7]).isEqualTo(DataType.BS);
        assertThat(digitDataTypeExtractor.getDataTypes()[8]).isEqualTo(DataType.BKB);
        assertThat(digitDataTypeExtractor.getDataTypes()[9]).isEqualTo(DataType.BUA);
        assertThat(digitDataTypeExtractor.getDataTypes()[10]).isEqualTo(DataType.BMI);
        assertThat(digitDataTypeExtractor.getDataTypes()[11]).isEqualTo(DataType.CI);
        assertThat(digitDataTypeExtractor.getDataTypes()[12]).isEqualTo(DataType.CPFI);
        assertThat(digitDataTypeExtractor.getDataTypes()[13]).isEqualTo(DataType.BMR);
    }
}
