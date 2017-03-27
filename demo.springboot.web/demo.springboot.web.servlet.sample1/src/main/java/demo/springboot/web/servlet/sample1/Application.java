package demo.springboot.web.servlet.sample1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * 
 * Package : demo.springboot.web.servlet.sample1
 * 
 * @See http://blog.csdn.net/catoop/article/details/50501686
 * @author YixinCapital -- zq 2017年3月16日 下午3:02:54
 *
 */
@SpringBootApplication
public class Application {
	
	/**
	 * 
	 * 使用代码注册Servlet（不需要@ServletComponentScan注解）
	 * @return 
	 * @author YixinCapital -- zq
	 *	       2017年3月16日 下午3:05:31
	 */
	@Bean
	public ServletRegistrationBean myServlet() {
		// ServletName默认值为首字母小写，即myServlet
		return new ServletRegistrationBean(new MyServlet(), "/xs/*");
	}
	
	@Bean
	public ServletRegistrationBean abcServlet() {
		// ServletName默认值为首字母小写，即myServlet
		return new ServletRegistrationBean(new ABCServlet(), "/xs/abc");
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
