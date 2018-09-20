package com.zq.demo.service;

import com.zq.demo.model.FinalData;
import com.zq.demo.repository.RedisRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhuqiang on 2018-09-06.
 */
@Component
public class KafkaService {

	private static AtomicInteger increment = new AtomicInteger(0);

	private final Logger logger = LoggerFactory.getLogger(KafkaService.class);

	@Autowired
	private RedisRepository redisRepository;

	@KafkaListener(topics = "demo")
	public void consumer(String message) {
		try {
			String[] datas = message.split(",");
			FinalData demoData = new FinalData();
			demoData.setKey(datas[1]);
			demoData.setValue(datas[2]);
			System.out.println(String.format("[%s] message: %s", increment.incrementAndGet(), message));
			redisRepository.add(demoData);
		}catch(Exception e){

		}
	}

}
