package com.zq.bigdata.config;

import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zhuqiang on 2018-09-06.
 */
public class Listener {

	private final CountDownLatch latch1 = new CountDownLatch(1);

	@KafkaListener(id = "foo", topics = "annotated1")
	public void listen1(String foo) {
		this.latch1.countDown();
	}
}
