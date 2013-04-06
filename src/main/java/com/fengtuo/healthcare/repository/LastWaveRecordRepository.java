package com.fengtuo.healthcare.repository;

import com.fengtuo.healthcare.model.LastWaveRecord;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/4/13
 * Time: 10:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class LastWaveRecordRepository extends RepositoryBase<LastWaveRecord> {
    private static final String COLLECTION = "LastWaveRecords";

    public LastWaveRecordRepository(MongoOperations mongoOperations) {
        super(mongoOperations, COLLECTION, LastWaveRecord.class);
    }

    public LastWaveRecordRepository() {
        this(null);
    }

    public void refreshLastWaveRecord(String userId, Date date){
        LastWaveRecord lastWaveRecord = FindLastWaveRecord(userId);
        if(lastWaveRecord==null){
            lastWaveRecord = new LastWaveRecord();
        }
        lastWaveRecord.setUserId(userId);
        lastWaveRecord.setTimestamp(date);
        save(lastWaveRecord);
    }

    public LastWaveRecord FindLastWaveRecord(String userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        return mongoOperations.findOne(query, LastWaveRecord.class, COLLECTION);
    }
}
