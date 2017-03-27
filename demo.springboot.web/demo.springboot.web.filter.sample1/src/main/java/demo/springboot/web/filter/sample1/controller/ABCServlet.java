/**
 * 2017年3月16日
 * zq
 */
package demo.springboot.web.filter.sample1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Package : demo.springboot.web.servlet.sample1
 * 
 * @author YixinCapital -- zq
 *		   2017年3月16日 下午3:18:21
 *
 */
public class ABCServlet extends HttpServlet{

	/**
	 * 
	 * @author YixinCapital -- zq
	 *		   2017年3月16日 下午3:18:45
	 *
	 */
	private static final long serialVersionUID = -3057252175274979881L;
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ABCServlet doGet()");
        doPost(req, resp);
    }
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ABCServlet doPost()");
        resp.setContentType("text/html");
        //设置编码否则可能会乱码
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();  
        out.println("<html>");  
        out.println("<head>");  
        out.println("<title>This ABC </title>");  
        out.println("</head>");  
        out.println("<body>");  
        out.println("<h1>大家好，我的名字叫ABCServlet</h1>");  
        out.println("</body>");  
        out.println("</html>"); 
    }

}
