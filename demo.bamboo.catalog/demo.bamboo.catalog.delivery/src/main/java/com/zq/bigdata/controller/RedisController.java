package com.zq.bigdata.controller;

import com.zq.bigdata.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping(path = "/redis")
public class RedisController {

    @Autowired
    private RedisRepository redisRepository;

    @GetMapping("/getall")
    public void getall() {
        Map<String, String>  datas = redisRepository.findAllDemoDatas();
        Set<String> keys = datas.keySet();
        for (String key: keys) {
            System.out.println(key);
        }
    }
}
