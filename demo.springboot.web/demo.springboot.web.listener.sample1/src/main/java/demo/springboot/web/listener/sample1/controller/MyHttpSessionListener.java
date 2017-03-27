/**
 * 2017年3月17日
 * zq
 */
package demo.springboot.web.listener.sample1.controller;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 
 * 监听Session的创建与销毁
 * 
 * Package : demo.springboot.web.listener.sample1.controller
 * 
 * @author YixinCapital -- zq
 *		   2017年3月17日 上午9:22:21
 *
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

	/**
	 * 
	 * @param se 
	 * @author YixinCapital -- zq
	 *	       2017年3月17日 上午9:22:21
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("MyHttpSessionListener 被创建");
	}

	/**
	 * 
	 * @param se 
	 * @author YixinCapital -- zq
	 *	       2017年3月17日 上午9:22:21
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("MyHttpSessionListener 初销毁");
	}

}
