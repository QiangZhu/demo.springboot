package com.yixin.demo.springboot.logback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yixin.demo.springboot.logback.debug.LogDebug;
import com.yixin.demo.springboot.logback.trace.LogTrace;
import com.yixin.demo.sprintboot.logback.info.LogInfo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		LogTrace.logTest();
		LogDebug.logTest();
		LogInfo.logTest();
	}
}
