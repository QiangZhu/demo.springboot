/**
 * 2017年3月16日
 * zq
 */
package demo.springboot.web.servlet.sample3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package : demo.springboot.web.servlet.sample3.controller
 * 
 * @author YixinCapital -- zq
 *		   2017年3月16日 下午3:42:53
 *
 */
@Controller
public class SampleController {
	
	
	@RequestMapping(value="/echo")
	@ResponseBody
	public  String echo(@RequestParam(name="name",required = false, defaultValue="Dear.") String name){
		return "echo :" + name;
	}

}
