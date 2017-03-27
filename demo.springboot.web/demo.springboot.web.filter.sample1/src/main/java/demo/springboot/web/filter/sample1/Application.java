/**
 * 2017年3月16日
 * zq
 */
package demo.springboot.web.filter.sample1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import demo.springboot.web.filter.sample1.controller.ABCFilter;
import demo.springboot.web.filter.sample1.controller.ABCServlet;
import demo.springboot.web.filter.sample1.controller.MyServlet;


/**
 * Package : demo.springboot.web.filter.sample1
 * 
 * @author YixinCapital -- zq
 *		   2017年3月16日 下午4:04:50
 *
 * 注意Filter要使用@ServletComponentScan注解扫描
 *
 */
@SpringBootApplication
public class Application {
	
	
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
	/**
	 * 使用编程的方式对指定Servlet进行过滤
	 * 
	 * @return 
	 * @author YixinCapital -- zq
	 *	       2017年3月16日 下午5:10:59
	 */
	@Bean
    public FilterRegistrationBean abcFilter(){
    	return new FilterRegistrationBean(new ABCFilter(),myServlet(),abcServlet());
    }

	/**
	 * 
	 * @param args 
	 * @author YixinCapital -- zq
	 *	       2017年3月16日 下午4:04:50
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class, args);
	}

}
