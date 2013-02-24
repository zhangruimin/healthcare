package com.fengtuo.healthcare.db;

import com.fengtuo.healthcare.repository.WaveRecordRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/22/13
 * Time: 5:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class MongoDbBaseTest {

    protected static MongoOperations mongoOperation;

    @BeforeClass
    public static void set_up_for_mongo_db(){
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(SpringMongoConfig.class);

        mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
    }
}
