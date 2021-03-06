package com.fengtuo.healthcare.repository;

import com.fengtuo.healthcare.model.WaveRecord;
import com.fengtuo.healthcare.model.WaveType;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/4/13
 * Time: 10:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class WaveRecordRepository extends RepositoryBase<WaveRecord> {
    private static final String COLLECTION = "WaveRecords";

    public WaveRecordRepository(MongoOperations mongoOperations) {
        super(mongoOperations, COLLECTION, WaveRecord.class);
    }

    public WaveRecordRepository() {
        this(null);
    }

    public WaveRecord nextRecord(String userId, Date date, WaveType waveType) {
        Query query = new Query();
        query.addCriteria(Criteria.where("timestamp").gt(date));
        query.addCriteria(Criteria.where("waveType").is(waveType));
        query.addCriteria(Criteria.where("userId").is(userId));
        query.with(new Sort(Sort.Direction.ASC, "timestamp"));
        return mongoOperations.findOne(query, WaveRecord.class, COLLECTION);
    }

    public List<WaveRecord> nextBatchRecord(String userId, Date date, WaveType waveType, int batchNum) {
        Query query = new Query();
        query.addCriteria(Criteria.where("timestamp").gt(date));
        query.addCriteria(Criteria.where("waveType").is(waveType));
        query.addCriteria(Criteria.where("userId").is(userId));
        query.with(new Sort(Sort.Direction.ASC, "timestamp"));
        List<WaveRecord> waveRecords = mongoOperations.find(query, WaveRecord.class, COLLECTION);
        return waveRecords.subList(0, Math.min(batchNum, waveRecords.size()));
    }

    public void deleteRecordsBefore(String userId, Date date) {
        Query query = new Query();
        query.addCriteria(Criteria.where("timestamp").lt(date));
        query.addCriteria(Criteria.where("userId").is(userId));
        List<WaveRecord> waveRecords = mongoOperations.find(query, WaveRecord.class, COLLECTION);
        if(waveRecords!=null){
            for(WaveRecord waveRecord:waveRecords){
                mongoOperations.remove(waveRecord);
            }
        }
//        mongoOperations.findAndRemove(query, WaveRecord.class, COLLECTION);
    }
}
