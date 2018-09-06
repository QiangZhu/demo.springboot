package com.zq.bigdata.repository;

import com.zq.bigdata.model.DemoData;

import java.util.Map;

public interface RedisRepository {

    /**
     * Return all movies
     */
    Map<String, String> findAllDemoDatas();

    /**
     * Add key-value pair to Redis.
     */
    void add(DemoData demoData);

    /**
     * Delete a key-value pair in Redis.
     */
    void delete(String keyValue);
    
    /**
     * find a movie
     */
    DemoData findByKeyValue(String keyValue);
    
}
