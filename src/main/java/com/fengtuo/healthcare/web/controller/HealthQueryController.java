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

import java.util.ArrayList;
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
public class HealthQueryController {
    private static final String HEALTH_QUERY = "healthQuery";
    private DigitRecordRepository digitRecordRepository;

    @Autowired
    public HealthQueryController(DigitRecordRepository digitRecordRepository){
        this.digitRecordRepository = digitRecordRepository;
    }
    @RequestMapping(method= RequestMethod.GET)
    public String index(ModelMap model) {

        List<DigitRecord> temperatureRecords = digitRecordRepository.find(DataType.TEMP1);
        List<DigitRecord> HRRecords = digitRecordRepository.find(DataType.HR);
        List<DigitRecord> SPO2Records = digitRecordRepository.find(DataType.SPO2);
        model.addAttribute("temperatureRecords", convert(temperatureRecords));
        model.addAttribute("HRRecords", convert(HRRecords));
        model.addAttribute("SPO2Records", convert(SPO2Records));
        return HEALTH_QUERY;
    }

    private List<DigitRecordDto> convert(List<DigitRecord> records){
        List<DigitRecordDto> result = new ArrayList<DigitRecordDto>();
        for(DigitRecord digitRecord:records){
            result.add(DigitRecordDto.from(digitRecord));
        }
        return result;
    }
}
