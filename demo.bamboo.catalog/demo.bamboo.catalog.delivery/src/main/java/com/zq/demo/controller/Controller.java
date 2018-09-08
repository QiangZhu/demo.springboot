package com.zq.demo.controller;

import com.zq.demo.config.SshConfig;
import com.zq.demo.dto.ExecDto;
import com.zq.demo.dto.FinalDto;
import com.zq.demo.dto.SshConfigDto;
import com.zq.demo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private Service service;

    @Autowired
    private SshConfig sshConfig;

    @GetMapping("/getall")
    @ResponseBody
    public List<FinalDto> getall() {
        return service.getall();
    }

    @PostMapping("/delivery")
    @ResponseBody
    public SshConfigDto delivery(@RequestBody SshConfigDto sshConfigDto) {
        try {
            sshConfig.setIp(sshConfigDto.getIp());
            sshConfig.setPort(sshConfigDto.getPort());
            sshConfig.setUser(sshConfigDto.getUser());
            sshConfig.setPassword(sshConfigDto.getPassword());
            sshConfig.setTargetDir(sshConfigDto.getTargetDir());
            sshConfig.setSourceFilePaths(Arrays.asList(sshConfigDto.getSourceFilePaths().split(",")));
            service.deliver();
        } catch (Exception e) {
        }
        return sshConfigDto;
    }

    @PostMapping("/execute")
    @ResponseBody
    public ExecDto execute(@RequestBody ExecDto execDto){
        try{
            return  service.execute(execDto);
        }catch(Exception e){
        }
        return execDto;
    }

    @PostMapping("/cancel")
    @ResponseBody
    public ExecDto cancel(@RequestBody ExecDto execDto){
        try{
            service.cancel(execDto);
        }catch(Exception e){
        }
        return execDto;
    }
}
