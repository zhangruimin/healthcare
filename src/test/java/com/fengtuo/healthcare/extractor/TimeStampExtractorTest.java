package com.fengtuo.healthcare.extractor;

import com.fengtuo.healthcare.extractor.TimeStampExtractor;
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
        Date timeStamp = TimeStampExtractor.extract(date);
        assertThat(timeStamp).isEqualTo(DateUtils.parse("2012-02-13 23:59:58"));
    }
}