/**
 * 2017年3月16日
 * zq
 */
package demo.springboot.web.listener.sample1;

import javax.servlet.http.HttpSessionListener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import demo.springboot.web.listener.sample1.controller.MySessionListener;

/**
 * Package : demo.springboot.web.listener.sample1
 * 
 * @author YixinCapital -- zq
 *		   2017年3月16日 下午5:15:53
 *
 */
@ServletComponentScan(basePackages={"demo.springboot.web.listener.sample1.controller"})
@SpringBootApplication
public class Application {
	
	@Bean
	public HttpSessionListener httpSessionListener(){
	    // MySessionListener should implement javax.servlet.http.HttpSessionListener
	    return new MySessionListener(); 
	}

	/**
	 * 
	 * @param args 
	 * @author YixinCapital -- zq
	 *	       2017年3月16日 下午5:15:53
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class, args);
	}

}
