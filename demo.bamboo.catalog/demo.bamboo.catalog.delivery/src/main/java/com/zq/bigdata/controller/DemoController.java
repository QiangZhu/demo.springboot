package com.zq.bigdata.controller;

import com.zq.bigdata.dto.DemoDto;
import com.zq.bigdata.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService ;

    @GetMapping("/getall")
    @ResponseBody
    public List<DemoDto> getall() {
        return demoService.getall();
    }
}
