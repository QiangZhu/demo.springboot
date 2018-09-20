package com.zq.demo.repository;

import com.zq.demo.model.FinalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.StringUtils;

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
    
    public void add(final FinalData demoData) {
        String keyValue = demoData.getKey()+","+demoData.getValue();
        keyValue = keyValue.replaceAll("\n","");
        if(!StringUtils.isEmptyOrWhitespace(keyValue)) {
            hashOperations.put(KEY, keyValue, keyValue);
        }
    }

    public void delete(final String key) {
        hashOperations.delete(KEY, key);
    }
    
    public FinalData findByKeyValue(final String keyValue){
        return (FinalData) hashOperations.get(KEY, keyValue);
    }

    @Override
    public void removeAll() {
        Map<String,String> map = hashOperations.entries(KEY);
        for(String hkey : map.keySet()){
            hashOperations.delete(KEY,hkey);
        }
    }

    public Map<String, String> findAllDemoDatas(){
        return hashOperations.entries(KEY);
    }

  
}
