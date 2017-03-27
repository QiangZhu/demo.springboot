/**
 * 2017年3月16日
 * zq
 */
package demo.springboot.web.servlet.sample3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Package : demo.springboot.web.servlet.sample3
 * 
 * @author YixinCapital -- zq 2017年3月16日 下午3:48:41
 *
 */
@ComponentScan(basePackages={"demo.springboot.web.servlet.sample3.controller"})
@SpringBootApplication
public class Application {
	
	
	/**
	 * 修改DispatcherServlet默认配置
	 * 
	 * @param dispatcherServlet
	 * @return 
	 * @author YixinCapital -- zq
	 *	       2017年3月16日 下午3:49:54
	 */
    @Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
        registration.getUrlMappings().clear();
        registration.addUrlMappings("*.do");
        registration.addUrlMappings("*.json");
        return registration;
    }

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
