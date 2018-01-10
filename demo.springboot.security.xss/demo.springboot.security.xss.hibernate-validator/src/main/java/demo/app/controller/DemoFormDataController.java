package demo.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.app.application.DemoService;
import demo.app.dto.DemoDto;

@Controller
public class DemoFormDataController {
	
	@Autowired
	private DemoService demoService;
	
	@RequestMapping(name = "/create",consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	@ResponseBody
	public  DemoDto create(DemoDto demoDto) {
		System.out.println(String.format("%s request %s", MediaType.MULTIPART_FORM_DATA_VALUE,demoDto));
		DemoDto result = null;
		try {
			result = demoService.createWithoutValid(demoDto);
			result  = demoService.create(demoDto);
		}catch(Throwable e ) {
			e.printStackTrace();
		}
		return result;
	}

}
