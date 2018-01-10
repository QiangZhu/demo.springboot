package demo.app.controller;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.app.dto.DemoDto;

@RestController
public class DemoRestController {
	
	
	@RequestMapping( path="/create", 
			consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE},
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public DemoDto create (@Valid @RequestBody DemoDto dto) {
		System.out.println(String.format("%s request %d", MediaType.APPLICATION_JSON_UTF8_VALUE,dto));
		return dto;
	}

}
