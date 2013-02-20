package com.fengtuo.healthcare.service;

import org.fest.assertions.Assertions;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/19/13
 * Time: 10:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class DeviceIdExtractorTest {
    @Test
    public void should_extract_device_id() throws Exception {
        String deviceId = DeviceIdExtractor.extract(new byte[]{0, 0, 0, 1});
        assertThat(deviceId).isEqualTo("1");
    }

    @Test
    public void should_extract_device_id_with_four_numbers() throws Exception {
        String deviceId = DeviceIdExtractor.extract(new byte[]{1, 1, 1, 1});
        assertThat(deviceId).isEqualTo(String.valueOf(1*256*256*256+1*256*256+1*256+1));
    }
}
