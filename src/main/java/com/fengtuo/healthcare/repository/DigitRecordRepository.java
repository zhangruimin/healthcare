package com.fengtuo.healthcare.repository;

import com.fengtuo.healthcare.model.DigitRecord;
import org.springframework.data.mongodb.core.MongoOperations;

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
}
