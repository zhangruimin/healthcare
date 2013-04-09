package com.fengtuo.healthcare.web.controller;

import com.fengtuo.healthcare.model.*;
import com.fengtuo.healthcare.repository.DigitRecordRepository;
import com.fengtuo.healthcare.repository.LastWaveRecordRepository;
import com.fengtuo.healthcare.repository.WaveRecordRepository;
import com.fengtuo.healthcare.web.dto.RealDigitDataDto;
import com.fengtuo.healthcare.web.dto.WaveRecordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/25/13
 * Time: 9:08 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/realTimeData")
public class RealTimeDataController extends BaseController {
    private static final int BATCH_NUM = 2;
    private static final String REAL_TIME_DATA = "realTimeData";
    private static final int WAIT_TIME = 5;
    private final WaveRecordRepository waveRecordRepository;
    private final DigitRecordRepository digitRecordRepository;
    private LastWaveRecordRepository lastWaveRecordRepository;

    @Autowired
    public RealTimeDataController(WaveRecordRepository waveRecordRepository,
                                  DigitRecordRepository digitRecordRepository,
                                  LastWaveRecordRepository lastWaveRecordRepository) {
        this.waveRecordRepository = waveRecordRepository;
        this.digitRecordRepository = digitRecordRepository;
        this.lastWaveRecordRepository = lastWaveRecordRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model) {
        return REAL_TIME_DATA;
    }

    @RequestMapping(value = "next", method = RequestMethod.GET)
    public
    @ResponseBody
    WaveRecordDto next(@RequestParam long timestamp, @RequestParam WaveType waveType, HttpSession session) {
        Date date = getDate(timestamp);
        String userId = getCurrentUser(session).getId();
        if (isNoDataReceived(userId)) {
            return WaveRecordDto.from(getEmptyWaveRecords(date, waveType));
        }
        List<WaveRecord> waveRecords = waveRecordRepository.nextBatchRecord(userId, date, waveType, BATCH_NUM);
        if (waveRecords.size() < BATCH_NUM) {
            return WaveRecordDto.from(getEmptyWaveRecords(date, waveType));
        }
        return WaveRecordDto.from(waveRecords);
    }

    private boolean isNoDataReceived(String userId) {
        LastWaveRecord lastWaveRecord = lastWaveRecordRepository.FindLastWaveRecord(userId);
        return lastWaveRecord == null
                || new Date().getTime() - lastWaveRecord.getTimestamp().getTime() > WAIT_TIME * 1000;
    }

    private List<WaveRecord> getEmptyWaveRecords(Date date, WaveType waveType) {
        List<WaveRecord> records = new ArrayList<WaveRecord>();
        WaveRecord waveRecord = new WaveRecord();
        waveRecord.setTimestamp(date);
        waveRecord.setData(new byte[WaveType.getDataByteNumber(waveType)]);
        for (int i = 0; i < BATCH_NUM; i++) {
            records.add(waveRecord);
        }
        return records;
    }

    @RequestMapping(value = "nextDigitData", method = RequestMethod.GET)
    public
    @ResponseBody
    RealDigitDataDto nextDigitData(HttpSession session) {
        String userId = getCurrentUser(session).getId();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -10);
        Date time = calendar.getTime();
        DigitRecord lastTemperature = digitRecordRepository.findLastRecordAfter(userId, DataType.TEMP1, time);
        DigitRecord lastHeartRate = digitRecordRepository.findLastRecordAfter(userId, DataType.HR, time);
        DigitRecord lastBloodOxygen = digitRecordRepository.findLastRecordAfter(userId, DataType.SPO2, time);
        RealDigitDataDto realDigitDataDto = new RealDigitDataDto();
        if (lastTemperature != null) {
            realDigitDataDto.setTemperature(lastTemperature.getDataString());
        }
        if (lastHeartRate != null) {
            realDigitDataDto.setHeartRate(lastHeartRate.getDataString());
        }
        if (lastBloodOxygen != null) {
            realDigitDataDto.setBloodOxygen(lastBloodOxygen.getDataString());
        }
        return realDigitDataDto;
    }

    @RequestMapping(value = "deleteAllRecords", method = RequestMethod.GET)
    public String deleteAllRecords(String password) {
        if("111111".equals(password))     {
            digitRecordRepository.removeAll();
            waveRecordRepository.removeAll();
            lastWaveRecordRepository.removeAll();
        }

        return "redirect:/realTimeData";
    }

    private Date getDate(long timestamp) {
        if (timestamp == 0) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.SECOND, -10);
            return calendar.getTime();
        }
        return new Date(timestamp);
    }

}
