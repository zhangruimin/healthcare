package com.fengtuo.healthcare.extractor;

import com.fengtuo.healthcare.util.DateUtils;
import org.junit.Test;

import java.util.Date;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/23/13
 * Time: 12:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class TimeStampExtractorTest {
    @Test
    public void should_extract_time_stamp() throws Exception {
        byte[] date = {12, 2, 13, 23, 59, 58};
        Date timestamp = TimeStampExtractor.extract(date);
        assertThat(timestamp).isEqualTo(DateUtils.parse("2012-02-13 23:59:58"));
    }

    @Test
    public void should_convert_date_to_bytes() throws Exception {
        byte[] expected = {13, 3, 1, 13, 50, 32};
        byte[] actual = TimeStampExtractor.toBytes(DateUtils.parse("2013-03-01 13:50:32"));
        assertThat(actual).isEqualTo(expected);
    }

//    public void should_convert_date_to_bytes() throws Exception {
//        byte[] expected = {13, 3, 1, 13, 50, 32};
//        byte[] actual = TimeStampExtractor.toBytes(DateUtils.parse("2013-03-01 13:50:32"));
//        assertThat(actual).isEqualTo(expected);
//    }

//    (byte)0x9B, (byte)0x0C, (byte)0x1E, (byte)0x00, (byte)0x00, (byte)0x00,
}
