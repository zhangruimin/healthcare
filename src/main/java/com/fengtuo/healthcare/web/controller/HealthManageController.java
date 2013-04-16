package com.fengtuo.healthcare.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fengtuo.healthcare.model.DataType;
import com.fengtuo.healthcare.model.DigitRecord;
import com.fengtuo.healthcare.repository.DigitRecordRepository;
import com.fengtuo.healthcare.web.dto.HealthManageDto;

/**
 * Created with IntelliJ IDEA. User: Administrator Date: 2/25/13 Time: 9:08 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/healthManage")
public class HealthManageController extends BaseController {

	private static final String HEALTH_MANAGE = "healthManage";
	private DigitRecordRepository digitRecordRepository;

	@Autowired
	public HealthManageController(DigitRecordRepository digitRecordRepository) {
		this.digitRecordRepository = digitRecordRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap model, HttpSession session, String timeRange) {
		return HEALTH_MANAGE;
	}

	@RequestMapping(value = "fetch", method = RequestMethod.GET)
	public @ResponseBody
	List<HealthManageDto> fetch(@RequestParam String timestamp,
			@RequestParam DataType dataType, HttpSession session) {

		Date startTime = getStartTime(timestamp);
		String userId = getCurrentUser(session).getId();
		List<DigitRecord> temperatureRecords = digitRecordRepository.find(
				userId, DataType.TEMP1, startTime);
		List<DigitRecord> HRRecords = digitRecordRepository.find(userId,
				DataType.HR, startTime);
		List<DigitRecord> SPO2Records = digitRecordRepository.find(userId,
				DataType.SPO2, startTime);
        List<DigitRecord> RESPRecords = digitRecordRepository.find(userId, DataType.RESP, startTime);
        List<DigitRecord> PRRecords = digitRecordRepository.find(userId, DataType.PR, startTime);
        List<DigitRecord> NIBPRecords = digitRecordRepository.find(userId, DataType.NIBP, startTime);
        List<DigitRecord> BSRecords = digitRecordRepository.find(userId, DataType.BS, startTime);
		
		//temp2 represents default value
		dataType=dataType!=null?dataType:DataType.TEMP2;
		
		return resultBuilder(dataType,temperatureRecords,HRRecords,SPO2Records,RESPRecords,PRRecords,NIBPRecords,BSRecords);

//		if (null != dataType) {
//			return convert(false);
//		} else {
//			return convert(true);
//		}
	}

	private HealthManageDto retrieveOneHealthManageDto(List<DigitRecord> records){
		HealthManageDto dd = new HealthManageDto();
		
		String[] data = new String[records.size()];
		String[] timeStamp = new String[records.size()];
		
		for(int i=0;i<records.size();i++){
			data[i]=records.get(i).getDataString();
			timeStamp[i]=formatDateByDefaultFormat(new Date(records.get(i).getTimestamp().getTime()));
		}
		
		dd.setData(data);
		dd.setTimestamp(timeStamp);
		
		return dd;
	}
	
	private List<HealthManageDto> resultBuilder(DataType dataType,
			List<DigitRecord> temperatureRecords, List<DigitRecord> hRRecords,
			List<DigitRecord> sPO2Records, List<DigitRecord> RESPRecords, List<DigitRecord> PRRecords,
			List<DigitRecord> NIBPRecords, List<DigitRecord> BSRecords) {
		
		List<HealthManageDto> result=new ArrayList<HealthManageDto>();
		
		switch(dataType){
		case TEMP1:
			result.add(retrieveOneHealthManageDto(temperatureRecords));
			break;
		case HR:
			result.add(retrieveOneHealthManageDto(hRRecords));
			break;
		case SPO2:
			result.add(retrieveOneHealthManageDto(sPO2Records));
			break;
		case RESP:
			result.add(retrieveOneHealthManageDto(RESPRecords));
			break;
		case PR:
			result.add(retrieveOneHealthManageDto(PRRecords));
			break;
		case NIBP:
			result.add(retrieveOneHealthManageDto(NIBPRecords));
			break;
		case BS:
			result.add(retrieveOneHealthManageDto(BSRecords));
			break;
		default:
			result.add(retrieveOneHealthManageDto(temperatureRecords));	
			result.add(retrieveOneHealthManageDto(hRRecords));
			result.add(retrieveOneHealthManageDto(sPO2Records));
			result.add(retrieveOneHealthManageDto(RESPRecords));
			result.add(retrieveOneHealthManageDto(PRRecords));
			result.add(retrieveOneHealthManageDto(NIBPRecords));
			result.add(retrieveOneHealthManageDto(BSRecords));
			break;
		}
		return result;
	}
	
	private static final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private String formatDateByDefaultFormat(Date date){
		return sdf.format(date);
	}
	
	private Date getStartTime(String timeRange) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		if ("LAST_DAY".equals(timeRange)) {
			return calendar.getTime();
		}
		if ("LAST_WEEK".equals(timeRange)) {
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			return calendar.getTime();
		}

		if ("LAST_MONTH".equals(timeRange)) {
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			return calendar.getTime();
		}

		return calendar.getTime();
	}

	// for testing only
	@Deprecated
	private HealthManageDto MockOneHealthManageDto() {
		HealthManageDto dd = new HealthManageDto();
		Random rand = new Random();
		String[] data = new String[10];
		String[] timeStamp = new String[10];
		for (int i = 0; i < 10; i++) {
			data[i] = String.valueOf(rand.nextDouble());
			timeStamp[i] = formatDateByDefaultFormat(new Date(System.currentTimeMillis()+i*10000));
		}
		dd.setData(data);
		dd.setTimestamp(timeStamp);
		return dd;
	}

	// for testing only
	@Deprecated
	private List<HealthManageDto> convert(boolean isMultiple) {
		List<HealthManageDto> ddl = new ArrayList<HealthManageDto>();

		if (!isMultiple) {
			ddl.add(MockOneHealthManageDto());
		} else {
			ddl.add(MockOneHealthManageDto());
			ddl.add(MockOneHealthManageDto());
			ddl.add(MockOneHealthManageDto());
			ddl.add(MockOneHealthManageDto());
			ddl.add(MockOneHealthManageDto());
			ddl.add(MockOneHealthManageDto());
			ddl.add(MockOneHealthManageDto());
		}
		return ddl;
	}
}
