package demo.app.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.app.dto.DemoDto;

@RestController
public class DemoController {
	
	@RequestMapping(name = "/create",consumes = {"application/json;charset=utf-8"})
	public DemoDto create(@Valid @RequestBody DemoDto demoDto) {
		System.out.println(String.format("create dto %s", demoDto));
		return demoDto;
	}

}
