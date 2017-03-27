/**
 * 2017年3月17日
 * zq
 */
package demo.springboot.web.listener.sample1.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Package : demo.springboot.web.listener.sample1.controller
 * 
 * @author YixinCapital -- zq
 *		   2017年3月17日 上午9:28:19
 *
 */
public class MySessionListener implements HttpSessionListener {

	/**
	 * 
	 * @param se 
	 * @author YixinCapital -- zq
	 *	       2017年3月17日 上午9:28:19
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println(" MySessionListener created session id:"+se.getSession().getId()+",attributes:"+getAttributes(se));
	}

	/**
	 * 
	 * @param se 
	 * @author YixinCapital -- zq
	 *	       2017年3月17日 上午9:28:19
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println(" MySessionListener destoryed session id:"+se.getSession().getId()+",attribtues:"+getAttributes(se));
	}

	/**
	 * 
	 * 
	 * @param se
	 * @return 
	 * @author YixinCapital -- zq
	 *	       2017年3月17日 上午9:52:43
	 */
	private String getAttributes(HttpSessionEvent se){
		Enumeration<String>  names = se.getSession().getAttributeNames();
		StringBuilder sb = new StringBuilder(32);
		sb.append("[");
		while(names.hasMoreElements()){
			String name = names.nextElement();
			sb.append("name:"+name);
			sb.append(",");
			sb.append("value:"+se.getSession().getAttribute(name));
		}
		sb.append("]");
		return sb.toString();
	}
}
