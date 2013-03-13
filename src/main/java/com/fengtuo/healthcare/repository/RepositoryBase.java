package com.fengtuo.healthcare.repository;

import org.springframework.data.mongodb.core.MongoOperations;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/4/13
 * Time: 10:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class RepositoryBase<T> {
    private final Class<T> type;
    private final String collectionName;

    public MongoOperations getMongoOperations() {
        return mongoOperations;
    }

    public void setMongoOperations(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    protected MongoOperations mongoOperations;

    public RepositoryBase(MongoOperations mongoOperations, String collectionName, Class<T> type) {
        this.mongoOperations = mongoOperations;
        this.collectionName = collectionName;
        this.type = type;
    }

    public void save(T record) {
        mongoOperations.save(record, collectionName);
    }

    public List<T> findAll() {
        return mongoOperations.findAll(type, collectionName);
    }

    public T findById(String id) {
        return mongoOperations.findById(id, type, collectionName);
    }

    public void removeAll(){
        mongoOperations.dropCollection(collectionName);
    }

    public void insert(List<T> records) {
        mongoOperations.insert(records,collectionName);
    }
}
