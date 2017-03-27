/**
 * 2017年3月16日
 * zq
 */
package demo.springboot.web.filter.sample1.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.boot.web.servlet.FilterRegistrationBean;

/**
 * Package : demo.springboot.web.filter.sample1.controller
 * 
 * @author YixinCapital -- zq
 *		   2017年3月16日 下午4:55:47
 *
 */
public class ABCFilter implements Filter {
	
	@Override
    public void destroy() {
        System.out.println("ABCFilter过滤器销毁");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        System.out.println("ABCFilter执行过滤操作");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("ABCFilter过滤器初始化");
    }

}
