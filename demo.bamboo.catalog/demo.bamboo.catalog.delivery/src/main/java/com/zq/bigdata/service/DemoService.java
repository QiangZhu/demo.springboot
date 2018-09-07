package com.zq.bigdata.service;
import com.zq.bigdata.dto.DemoDto;
import com.zq.bigdata.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class DemoService {

    @Autowired
    private RedisRepository redisRepository;

    public List<DemoDto> getall() {
        Map<String, String> datas = redisRepository.findAllDemoDatas();
        ConcurrentHashMap<String, SortedSet<String>> map = new ConcurrentHashMap<>();
        Set<String> keyValues = datas.keySet();
        for (String keyValue: keyValues) {
            String[] temp = keyValue.split(",");
            if (temp != null && temp.length >= 2){
                SortedSet values = null;
                if (map.containsKey(temp[0])) {
                    values = map.get(temp[0]);
                } else {
                    values = new TreeSet<String>();
                }
                values.add(temp[1]);
                map.put(temp[0], values);
            }
        }
        List<DemoDto> result = new ArrayList();
        for (Map.Entry<String, SortedSet<String>> entry : map.entrySet()) {
            DemoDto dto = new DemoDto();
            dto.setKey(entry.getKey());
            List<String> values = new ArrayList<>();
            for (String value : entry.getValue()){
                values.add(value);
            }
            dto.setValues(values);
            result.add(dto);
        }
        return result;
    }
}
