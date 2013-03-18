package com.fengtuo.healthcare.repository;

import com.fengtuo.healthcare.model.DataType;
import com.fengtuo.healthcare.model.DigitRecord;
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
public class DigitRecordRepository extends RepositoryBase<DigitRecord> {
    private static final String COLLECTION = "DigitRecords";

    public DigitRecordRepository(MongoOperations mongoOperations) {
        super(mongoOperations, COLLECTION, DigitRecord.class);
    }

    public DigitRecordRepository() {
        this(null);
    }

    public List<DigitRecord> find(String userId, DataType dataType, Date startTime) {
        Query query = new Query(Criteria.where("dataType").is(dataType));
        query.addCriteria(Criteria.where("userId").is(userId));
        query.addCriteria(Criteria.where("timestamp").gte(startTime));
        return mongoOperations.find(query, DigitRecord.class, COLLECTION);
    }

    public DigitRecord findLastRecordAfter(String userId, DataType dataType, Date startTime) {
        Query query = new Query(Criteria.where("dataType").is(dataType));
        query.addCriteria(Criteria.where("userId").is(userId));
        query.addCriteria(Criteria.where("timestamp").gte(startTime));
        query.with(new Sort(Sort.Direction.DESC, "timestamp"));
        return mongoOperations.findOne(query, DigitRecord.class, COLLECTION);
    }
}
