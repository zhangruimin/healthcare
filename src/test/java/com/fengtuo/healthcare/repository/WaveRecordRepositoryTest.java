package com.fengtuo.healthcare.repository;

import com.fengtuo.healthcare.db.SpringMongoConfig;
import com.fengtuo.healthcare.model.WaveRecord;
import com.fengtuo.healthcare.model.WaveType;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class WaveRecordRepositoryTest
{
    private WaveRecordRepository repository;

    @Before
    public void set_up(){
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(SpringMongoConfig.class);

        MongoOperations mongoOperation =
                (MongoOperations) ctx.getBean("mongoTemplate");
        repository = new WaveRecordRepository(mongoOperation);
        repository.removeAll();
    }

    @Test
    public void should_save_wave_record() throws Exception {
        WaveRecord waveRecord = new WaveRecord("XMD-110");
        waveRecord.setWaveType(WaveType.HR);
        byte[] data = {0, 1, 3};
        waveRecord.setData(data);
        repository.save(waveRecord);

        // find
        List<WaveRecord> records = repository.findAll();
        assertThat(records).isNotEmpty();
        assertThat(records.size()).isEqualTo(1);
        WaveRecord record = records.get(0);
        assertThat(record.getWaveType()).isEqualTo(WaveType.HR);
        assertThat(record.getData()).isEqualTo(data);
    }
}
