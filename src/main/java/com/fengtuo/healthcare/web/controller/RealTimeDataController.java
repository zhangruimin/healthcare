package com.fengtuo.healthcare.web.controller;

import com.fengtuo.healthcare.model.DataType;
import com.fengtuo.healthcare.model.DigitRecord;
import com.fengtuo.healthcare.model.WaveRecord;
import com.fengtuo.healthcare.model.WaveType;
import com.fengtuo.healthcare.repository.DigitRecordRepository;
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
    private static final String REAL_TIME_DATA = "realTimeData";
    private final WaveRecordRepository waveRecordRepository;
    private final DigitRecordRepository digitRecordRepository;

    @Autowired
    public RealTimeDataController(WaveRecordRepository waveRecordRepository, DigitRecordRepository digitRecordRepository) {
        this.waveRecordRepository = waveRecordRepository;
        this.digitRecordRepository = digitRecordRepository;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String index(ModelMap model) {
        return REAL_TIME_DATA;
    }

    @RequestMapping(value = "next", method= RequestMethod.GET)
    public
    @ResponseBody
    WaveRecordDto next(@RequestParam long timestamp,@RequestParam WaveType waveType, HttpSession session) {
        Date date = getDate(timestamp);
        String userId = getCurrentUser(session).getId();
        WaveRecord waveRecord = waveRecordRepository.nextRecord(userId, date, waveType);
        WaveRecord waveRecord1 = null;
        if(waveRecord!=null){
            waveRecord1 = waveRecordRepository.nextRecord(userId, waveRecord.getTimestamp(), waveType);
        }

        List<WaveRecord> records = new ArrayList<WaveRecord>();
        if(waveRecord == null || waveRecord1==null){
            waveRecord = new WaveRecord();
            waveRecord.setTimestamp(date);
            waveRecord.setData(new byte[WaveType.getDataByteNumber(waveType)]);
            records.add(waveRecord);
            records.add(waveRecord);
        }   else{
            records.add(waveRecord);
            records.add(waveRecord1);
        }

        return WaveRecordDto.from(records);
    }

    @RequestMapping(value = "nextDigitData", method= RequestMethod.GET)
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
        if(lastTemperature!=null){
            realDigitDataDto.setTemperature(lastTemperature.getDataString());
        }
        if(lastHeartRate!=null){
            realDigitDataDto.setHeartRate(lastHeartRate.getDataString());
        }
        if(lastBloodOxygen!=null){
            realDigitDataDto.setBloodOxygen(lastBloodOxygen.getDataString());
        }
        return realDigitDataDto;
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
