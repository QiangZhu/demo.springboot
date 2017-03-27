/**
 * 2017年3月16日
 * zq
 */
package demo.springboot.web.servlet.sample2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Package : demo.springboot.web.servlet.sample2
 * 
 * @author YixinCapital -- zq
 *		   2017年3月16日 下午3:29:03
 *
 */
@ServletComponentScan(basePackages={"demo.springboot.web.servelet.sample2.controller"})
@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
