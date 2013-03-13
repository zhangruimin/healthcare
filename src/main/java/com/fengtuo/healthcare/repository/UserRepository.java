package com.fengtuo.healthcare.repository;

import com.fengtuo.healthcare.model.User;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 3/13/13
 * Time: 9:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserRepository extends RepositoryBase<User> {
    private static final String COLLECTION = "Users";
    public UserRepository(MongoOperations mongoOperations) {
        super(mongoOperations, COLLECTION, User.class);
    }

    public UserRepository() {
        this(null);
    }
}