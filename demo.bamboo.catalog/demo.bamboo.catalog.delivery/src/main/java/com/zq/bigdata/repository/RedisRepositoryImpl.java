package com.zq.bigdata.repository;

import com.zq.bigdata.model.DemoData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
public class RedisRepositoryImpl implements RedisRepository {
    private static final String KEY = "catalog";
    
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;
    
    @Autowired
    public RedisRepositoryImpl(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
    }
    
    public void add(final DemoData demoData) {
        String keyValue = demoData.getKey()+","+demoData.getValue();
        hashOperations.put(KEY, keyValue, keyValue);
    }

    public void delete(final String key) {
        hashOperations.delete(KEY, key);
    }
    
    public DemoData findByKeyValue(final String keyValue){
        return (DemoData) hashOperations.get(KEY, keyValue);
    }
    
    public Map<String, String> findAllDemoDatas(){
        return hashOperations.entries(KEY);
    }

  
}
