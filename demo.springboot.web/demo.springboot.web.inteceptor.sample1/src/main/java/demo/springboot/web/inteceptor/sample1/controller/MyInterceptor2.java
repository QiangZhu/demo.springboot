/**
 * 2017年3月17日
 * zq
 */
package demo.springboot.web.inteceptor.sample1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Package : demo.springboot.web.inteceptor.sample1.controller
 * 
 * @author YixinCapital -- zq
 *		   2017年3月17日 上午10:11:22
 *
 */
public class MyInterceptor2 implements HandlerInterceptor {

	/**
	 * 
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception 
	 * @author YixinCapital -- zq
	 *	       2017年3月17日 上午10:11:22
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println(">>>MyInterceptor2>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");

        return true;// 只有返回true才会继续向下执行，返回false取消当前请求
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @throws Exception 
	 * @author YixinCapital -- zq
	 *	       2017年3月17日 上午10:11:22
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println(">>>MyInterceptor2>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception 
	 * @author YixinCapital -- zq
	 *	       2017年3月17日 上午10:11:22
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println(">>>MyInterceptor2>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
	}

}
