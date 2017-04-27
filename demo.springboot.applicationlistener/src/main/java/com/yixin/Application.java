package com.yixin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application {
	
	@Autowired
	private MyBean myBean;

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).listeners(new MyApplicationListener()).run(args);
		
	}
}
