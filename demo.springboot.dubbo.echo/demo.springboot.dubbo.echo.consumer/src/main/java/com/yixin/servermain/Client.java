package com.yixin.servermain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.yixin.demo.springboot.dubbo.echo.consumer.EchoServiceConsumer;

@SpringBootApplication
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext run = SpringApplication.run(Client.class, args);
		EchoServiceConsumer bean = run.getBean(EchoServiceConsumer.class);
        System.out.println(bean.invokeEchoService("Hello World! ^_^ "));
	}

}
