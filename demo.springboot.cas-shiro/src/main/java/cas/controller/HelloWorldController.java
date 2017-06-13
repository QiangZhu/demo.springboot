package cas.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello")
public class HelloWorldController {
	
	@RequestMapping(value = "/world",method = RequestMethod.GET)
    public @ResponseBody String helloworld(){
        return "hello world!";
    }

}
