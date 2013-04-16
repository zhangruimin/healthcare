package com.fengtuo.healthcare.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.fengtuo.healthcare.model.User;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 3/13/13
 * Time: 9:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserRepository extends RepositoryBase<User> {
    private static Map<String, String> cache = new ConcurrentHashMap<String, String>();
    private static final String COLLECTION = "Users";

    public UserRepository(MongoOperations mongoOperations) {
    	 super(mongoOperations, COLLECTION, User.class);
    }

    public UserRepository() {
        this(null);
    }

    public String findUser(String deviceId) {
        if (cache.containsKey(deviceId)) {
            return cache.get(deviceId);
        }
        Query query = new Query();
        query.addCriteria(Criteria.where("devices").elemMatch(Criteria.where("deviceId").is(deviceId)));
        User user = mongoOperations.findOne(query, User.class, COLLECTION);
        cache.put(deviceId, user.getId());
        return user.getId();
    }

    public User findUser(String userName, String password) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userName").is(userName));
        query.addCriteria(Criteria.where("password").is(password));
        return mongoOperations.findOne(query, User.class, COLLECTION);
    }
}