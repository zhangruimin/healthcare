package com.fengtuo.healthcare.repository;

import com.fengtuo.healthcare.model.DataType;
import com.fengtuo.healthcare.model.DigitRecord;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

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

    public List<DigitRecord> find(DataType dataType) {
        return mongoOperations.find(new Query(Criteria.where("dataType").is(dataType)), DigitRecord.class, COLLECTION);
    }
}
