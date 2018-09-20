package com.zq.demo.controller;

import com.zq.demo.config.SshConfig;
import com.zq.demo.dto.ExecDto;
import com.zq.demo.dto.FinalDto;
import com.zq.demo.dto.SshConfigDto;
import com.zq.demo.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private Service service;

    @Autowired
    private SshConfig sshConfig;

    @GetMapping("/getall")
    @ResponseBody
    public List<FinalDto> getall() {
        return service.getall();
    }

    @GetMapping("removeall")
    @ResponseBody
    public List<FinalDto> removeall() {
        return service.removeall();
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
            logger.error("It's failed to delivery {},",sshConfigDto,e);
        }
        return sshConfigDto;
    }

    @PostMapping("/sample")
    @ResponseBody
    public ExecDto sample(@RequestBody ExecDto execDto){
        try{
            return  service.sample(execDto);
        }catch(Exception e){
            logger.error("It's failed to execute {}",execDto,e);
        }
        return execDto;
    }

    @PostMapping("/execute")
    @ResponseBody
    public ExecDto execute(@RequestBody ExecDto execDto){
        try{
            return  service.execute(execDto);
        }catch(Exception e){
            logger.error("It's failed to execute {}",execDto,e);
        }
        return execDto;
    }

    @PostMapping("/cancel")
    @ResponseBody
    public ExecDto cancel(@RequestBody ExecDto execDto){
        try{
            service.cancel(execDto);
        }catch(Exception e){
            logger.error("It's failed to cancel {},",execDto,e);
        }
        return execDto;
    }
}
