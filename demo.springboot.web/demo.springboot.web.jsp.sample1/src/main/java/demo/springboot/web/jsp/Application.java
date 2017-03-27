package demo.springboot.web.jsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * Package : com.yixin.demo.springboot.web.jsp
 * 
 * @See http://blog.csdn.net/catoop/article/details/50501676
 * @author YixinCapital -- zq
 *		   2017年3月16日 上午10:58:08
 *
 */
@ComponentScan(basePackages={"demo.springboot.web.jsp.controller"})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
