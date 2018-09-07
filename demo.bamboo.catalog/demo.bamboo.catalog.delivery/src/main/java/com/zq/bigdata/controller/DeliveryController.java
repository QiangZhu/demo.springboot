package com.zq.bigdata.controller;

import com.zq.bigdata.config.SshConfig;
import com.zq.bigdata.dto.SshConfigDto;
import com.zq.bigdata.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @Autowired
    private SshConfig sshConfig;

    @PostMapping("/delivery")
    @ResponseBody
    public SshConfigDto delivery(@RequestBody SshConfigDto sshConfigDto ) {
        sshConfig.setIp(sshConfigDto.getIp());
        sshConfig.setPort(sshConfigDto.getPort());
        sshConfig.setUser(sshConfigDto.getUser());
        sshConfig.setPassword(sshConfigDto.getPassword());
        sshConfig.setTargetDir(sshConfigDto.getTargetDir());
        sshConfig.setSourceFilePaths(Arrays.asList(sshConfigDto.getSourceFilePaths().split(",")));
        deliveryService.deliver();
        return sshConfigDto;
    }
}
