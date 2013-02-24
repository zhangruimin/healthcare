package com.fengtuo.healthcare.repository;

import com.fengtuo.healthcare.db.MongoDbBaseTest;
import com.fengtuo.healthcare.db.SpringMongoConfig;
import com.fengtuo.healthcare.model.DataType;
import com.fengtuo.healthcare.model.DigitRecord;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;


public class DigitRecordRepositoryTest extends MongoDbBaseTest
{
    private DigitRecordRepository repository;

    @Before
    public void set_up(){
        repository = new DigitRecordRepository(mongoOperation);
        repository.removeAll();
    }

    @Test
    public void should_save_digit_record() throws Exception {
        DigitRecord digitRecord = new DigitRecord("XMD-110");
        digitRecord.setDataType(DataType.HR);
        byte[] data = {0, 1, 3};
        digitRecord.setData(data);
        repository.save(digitRecord);

        // find
        List<DigitRecord> records = repository.findAll();
        assertThat(records).isNotEmpty();
        assertThat(records.size()).isEqualTo(1);
        DigitRecord record = records.get(0);
        assertThat(record.getDataType()).isEqualTo(DataType.HR);
        assertThat(record.getData()).isEqualTo(data);
    }
}
