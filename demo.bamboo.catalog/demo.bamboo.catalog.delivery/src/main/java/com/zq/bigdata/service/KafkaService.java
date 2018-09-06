package com.zq.bigdata.service;

import com.zq.bigdata.model.DemoData;
import com.zq.bigdata.repository.RedisRepository;
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
		DemoData demoData = new DemoData();
		demoData.setKey(datas[1]);
		demoData.setValue(datas[2]);
		System.out.print("====>"+message);
		redisRepository.add(demoData);
	}

}
