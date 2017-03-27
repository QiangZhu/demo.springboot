/**
 * 2017年3月16日
 * zq
 */
package demo.springboot.web.listener.sample1.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 
 * 监听Session的创建与销毁
 * 
 * Package : demo.springboot.web.listener.sample1.controller
 * 
 * @author YixinCapital -- zq
 *		   2017年3月16日 下午5:17:13
 *
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("MyServletContextListener 被创建");
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("MyServletContextListener 被销毁");
	}



}
