package demo.springboot.web.jsp.sample2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * Package : com.yixin.demo.springboot.web.jsp
 * 
 * @See http://stackoverflow.com/questions/35133935/cant-configure-viewresolver-in-spring-boot-application
 * @author YixinCapital -- zq
 *		   2017年3月16日 上午10:58:08
 *
 */
@ComponentScan(basePackages={"demo.springboot.web.jsp.sample2"})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
