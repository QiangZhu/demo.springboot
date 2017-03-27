/**
 * 2017年3月17日
 * zq
 */
package demo.springboot.web.inteceptor.sample1.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * MyWebAppConfigurer 使用 @Configuration 组装到SpringMVC
 * 
 * 
 * Package : demo.springboot.web.inteceptor.sample1.controller
 * 
 * @author YixinCapital -- zq
 *		   2017年3月17日 上午10:12:33
 *
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**");
        registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
