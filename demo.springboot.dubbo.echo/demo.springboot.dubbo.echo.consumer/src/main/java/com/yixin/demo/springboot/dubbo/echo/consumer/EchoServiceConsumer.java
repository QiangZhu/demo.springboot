package com.yixin.demo.springboot.dubbo.echo.consumer;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yixin.demo.springboot.dubbo.echo.api.EchoService;

/**
 * Hello world!
 *
 */
@Component
public class EchoServiceConsumer 
{

	@Reference(version="1.0.0")
	public EchoService echoSerivce;
	
	public void setEchoSerivce(EchoService echoSerivce) {
		this.echoSerivce = echoSerivce;
	}

	public String invokeEchoService(String input){
		
		return this.echoSerivce.echo(input);
		
	}
	
}
