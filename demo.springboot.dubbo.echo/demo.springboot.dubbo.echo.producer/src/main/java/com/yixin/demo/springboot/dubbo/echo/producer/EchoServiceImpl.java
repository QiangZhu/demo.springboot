package com.yixin.demo.springboot.dubbo.echo.producer;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.yixin.demo.springboot.dubbo.echo.api.EchoService;

/**
 * Hello world!
 *
 */
@Service(version = "1.0.0")
public class EchoServiceImpl implements  EchoService
{
	@Override
	public String echo(String input) {
		// TODO Auto-generated method stub
		return "server echo:"+input;
	}

}
