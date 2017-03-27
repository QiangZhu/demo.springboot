/**
 * 2017年3月16日
 * zq
 */
package demo.springboot.web.servlet.sample1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Package : demo.springboot.web.servlet.sample1
 * 
 * @author YixinCapital -- zq
 *		   2017年3月16日 下午3:04:01
 *
 */
public class MyServlet extends HttpServlet{

	/**
	 * 
	 * @author YixinCapital -- zq
	 *		   2017年3月16日 下午3:06:21
	 *
	 */
	private static final long serialVersionUID = -1766636819892585259L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MyServlet doGet()");
        doPost(req, resp);
    }
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MyServlet doPost()");
        resp.setContentType("text/html");
        //设置编码否则可能会乱码
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();  
        out.println("<html>");  
        out.println("<head>");  
        out.println("<title>Hello World</title>");  
        out.println("</head>");  
        out.println("<body>");  
        out.println("<h1>大家好，我的名字叫Servlet</h1>");  
        out.println("</body>");  
        out.println("</html>"); 
    }

}
