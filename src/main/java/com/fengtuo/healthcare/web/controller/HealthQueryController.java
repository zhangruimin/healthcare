package com.fengtuo.healthcare.web.controller;

import com.fengtuo.healthcare.model.DataType;
import com.fengtuo.healthcare.model.DigitRecord;
import com.fengtuo.healthcare.repository.DigitRecordRepository;
import com.fengtuo.healthcare.web.dto.DigitRecordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
@RequestMapping("/healthQuery")
public class HealthQueryController extends BaseController{
    private static final String HEALTH_QUERY = "healthQuery";
    private DigitRecordRepository digitRecordRepository;

    @Autowired
    public HealthQueryController(DigitRecordRepository digitRecordRepository){
        this.digitRecordRepository = digitRecordRepository;
    }
    @RequestMapping(method= RequestMethod.GET)
    public String index(ModelMap model, HttpSession session, String timeRange) {
        Date startTime = getStartTime(timeRange);
        String userId =getCurrentUser(session).getId();
        List<DigitRecord> temperatureRecords = digitRecordRepository.find(userId, DataType.TEMP1, startTime);
        List<DigitRecord> HRRecords = digitRecordRepository.find(userId, DataType.HR, startTime);
        List<DigitRecord> SPO2Records = digitRecordRepository.find(userId, DataType.SPO2, startTime);
        List<DigitRecord> RESPRecords = digitRecordRepository.find(userId, DataType.RESP, startTime);
        List<DigitRecord> PRRecords = digitRecordRepository.find(userId, DataType.PR, startTime);
        List<DigitRecord> NIBPRecords = digitRecordRepository.find(userId, DataType.NIBP, startTime);
        List<DigitRecord> BSRecords = digitRecordRepository.find(userId, DataType.BS, startTime);
        
        model.addAttribute("temperatureRecords", convert(temperatureRecords));
        model.addAttribute("HRRecords", convert(HRRecords));
        model.addAttribute("SPO2Records", convert(SPO2Records));
        
        model.addAttribute("RESPRecords", convert(RESPRecords));
        model.addAttribute("PRRecords", convert(PRRecords));
        model.addAttribute("NIBPRecords", convert(NIBPRecords));
        model.addAttribute("BSRecords", convert(BSRecords));
        
        return HEALTH_QUERY;
    }

    private Date getStartTime(String timeRange) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        if("LAST_DAY".equals(timeRange)){
            return calendar.getTime();
        }
        if("LAST_WEEK".equals(timeRange)){
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            return calendar.getTime();
        }

        if("LAST_MONTH".equals(timeRange)){
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            return calendar.getTime();
        }

        return calendar.getTime();
    }

    private List<DigitRecordDto> convert(List<DigitRecord> records){
        List<DigitRecordDto> result = new ArrayList<DigitRecordDto>();
        for(DigitRecord digitRecord:records){
            result.add(DigitRecordDto.from(digitRecord));
        }
        return result;
    }
}

