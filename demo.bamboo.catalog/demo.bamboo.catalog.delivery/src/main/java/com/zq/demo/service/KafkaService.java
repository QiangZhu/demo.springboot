package com.zq.demo.service;

import com.zq.demo.model.FinalData;
import com.zq.demo.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhuqiang on 2018-09-06.
 */
@Component
public class KafkaService {

	@Autowired
	private RedisRepository redisRepository;

	@KafkaListener(topics = "demo")
	public void consumer(String message) {

		String[] datas = message.split(",");
		FinalData demoData = new FinalData();
		demoData.setKey(datas[1]);
		demoData.setValue(datas[2]);
		System.out.print("====>"+message);
		redisRepository.add(demoData);
	}

}
