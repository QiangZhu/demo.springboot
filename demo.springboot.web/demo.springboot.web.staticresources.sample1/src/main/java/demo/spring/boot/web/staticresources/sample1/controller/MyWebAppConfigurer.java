/**
 * 2017年3月17日
 * zq
 */
package demo.spring.boot.web.staticresources.sample1.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Package : demo.spring.boot.web.staticresources.sample1.controller
 * 
 * @author YixinCapital -- zq
 *		   2017年3月17日 上午10:52:10
 *
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
	
	/**
	 * 
	 * 以多次使用 addResourceLocations 添加目录，优先级先添加的高于后添加的
	 * 
	 * @param registry 
	 * @author YixinCapital -- zq
	 *	       2017年3月17日 下午2:11:16
	 */
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//使用类路径
        //registry.addResourceHandler("/myres/**").addResourceLocations("classpath:/myres/");
		//使用绝对路径
		//registry.addResourceHandler("/myres/**").addResourceLocations("file:d:/temp/myres/");
        registry.addResourceHandler("/myres/**").addResourceLocations("classpath:/myres/").addResourceLocations("file:d:/temp/myres/");
        super.addResourceHandlers(registry);
    }
}
