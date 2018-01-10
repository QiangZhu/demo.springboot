package demo.app.controller;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.app.dto.DemoDto;

@Controller
public class DemoFormDataController {
	
	@RequestMapping(name = "/create",consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	@ResponseBody
	public  DemoDto create(@Valid DemoDto demoDto) {
		System.out.println(String.format("%s request %s", MediaType.APPLICATION_FORM_URLENCODED_VALUE,demoDto));
		return demoDto;
	}

}
