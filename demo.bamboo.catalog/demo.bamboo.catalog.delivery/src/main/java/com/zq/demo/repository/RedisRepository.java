package com.zq.demo.repository;

import com.zq.demo.model.FinalData;

import java.util.Map;

public interface RedisRepository {

    /**
     * Return all movies
     */
    Map<String, String> findAllDemoDatas();

    /**
     * Add key-value pair to Redis.
     */
    void add(FinalData demoData);

    /**
     * Delete a key-value pair in Redis.
     */
    void delete(String keyValue);
    
    /**
     * find a movie
     */
    FinalData findByKeyValue(String keyValue);
    
}
