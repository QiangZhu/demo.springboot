/**
 * 2017年3月16日
 * zq
 */
package demo.springboot.web.jsp.sample2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Package : demo.springboot.web.jsp.sample2.controller
 * 
 * @author YixinCapital -- zq
 *		   2017年3月16日 下午1:57:32
 *
 */
@Controller
public class IndexController {

	@RequestMapping("/")
    public String index() {
        return "index";
    }
	
	@RequestMapping("/page")
	public String page(Model model){
	      model.addAttribute("title","Mainstay - Web");
	      return "index";
	}
}
