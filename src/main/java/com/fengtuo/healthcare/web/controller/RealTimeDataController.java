package com.fengtuo.healthcare.web.controller;

import com.fengtuo.healthcare.model.WaveRecord;
import com.fengtuo.healthcare.model.WaveType;
import com.fengtuo.healthcare.repository.WaveRecordRepository;
import com.fengtuo.healthcare.web.dto.WaveRecordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/25/13
 * Time: 9:08 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/realTimeData")
public class RealTimeDataController {
    private static final String REAL_TIME_DATA = "realTimeData";
    private final WaveRecordRepository waveRecordRepository;

    @Autowired
    public RealTimeDataController(WaveRecordRepository waveRecordRepository) {
        this.waveRecordRepository = waveRecordRepository;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String index(ModelMap model) {
        return REAL_TIME_DATA;
    }

    @RequestMapping(value = "next", method= RequestMethod.GET)
    public
    @ResponseBody
    WaveRecordDto next(@RequestParam long timestamp,@RequestParam WaveType waveType) {
        Date date = getDate(timestamp);
        WaveRecord waveRecord = waveRecordRepository.nextRecord(date, waveType);
        if(waveRecord == null){
            waveRecord = new WaveRecord();
            waveRecord.setTimestamp(date);
            waveRecord.setData(new byte[WaveType.getDataByteNumber(waveType)]);
        }
        return WaveRecordDto.from(waveRecord);
    }

    private Date getDate(long timestamp) {
        if(timestamp == 0){
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.SECOND, -10);
            return calendar.getTime();
        }
        return new Date(timestamp);
    }

}
