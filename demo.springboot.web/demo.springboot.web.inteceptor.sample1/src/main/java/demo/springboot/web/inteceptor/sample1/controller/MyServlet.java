/**
 * 2017年3月16日
 * zq
 */
package demo.springboot.web.inteceptor.sample1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Package : demo.springboot.web.servelet.sample2.controller
 * 
 * @author YixinCapital -- zq
 *		   2017年3月16日 下午3:31:46
 * @WebServlet
 * 不指定name的情况下，name默认值为类全路径，即org.springboot.sample.servlet.MyServlet2
 */

@WebServlet(urlPatterns="/xs/*", description="MyServlet") 
public class MyServlet extends HttpServlet {

	/**
	 * 
	 * @author YixinCapital -- zq
	 *		   2017年3月16日 下午3:32:57
	 *
	 */
	private static final long serialVersionUID = 3738294293396074723L;
	
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
