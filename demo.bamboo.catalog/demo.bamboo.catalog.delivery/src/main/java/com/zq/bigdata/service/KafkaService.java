package com.zq.bigdata.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhuqiang on 2018-09-06.
 */
@Component
public class KafkaService {

	@KafkaListener(topics = "demo")
	public void consumer(String message) {
		System.out.print("=======>" + message);
	}

}
