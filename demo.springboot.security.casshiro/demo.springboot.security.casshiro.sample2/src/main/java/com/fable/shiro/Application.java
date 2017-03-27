package com.fable.shiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Administrator on 2016/12/1 0001.
 */
//启注解事务管理
@EnableTransactionManagement
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        System.out.println("以jar包方式启动...");
        SpringApplication.run(Application.class, args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        System.out.println("以war包方式启动...");
        return builder.sources(this.getClass());
    }
}
