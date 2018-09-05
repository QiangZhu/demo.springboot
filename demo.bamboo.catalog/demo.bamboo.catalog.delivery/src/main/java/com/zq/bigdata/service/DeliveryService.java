package com.zq.bigdata.service;

import com.jcraft.jsch.Session;
import com.zq.bigdata.common.SshFileSender;
import com.zq.bigdata.common.SshSession;
import com.zq.bigdata.config.SshConfig;
import com.zq.bigdata.controller.DeliveryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class DeliveryService {

    @Autowired
    private SshConfig sshConfig;

    public void deliver(){
        SshSession  sshSession = new SshSession();
        Session session = sshSession.openSession(sshConfig.getUser(), sshConfig.getPassword(),
                sshConfig.getIp(),sshConfig.getPort());
        SshFileSender fileSender = new SshFileSender(session);
        System.out.println(DeliveryService.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        boolean isUploaded = fileSender.upload(sshConfig.getDir(), new File(
                "d:/test/python/extract/extract.py"));
        boolean isFileUploaded = fileSender.upload(
                sshConfig.getDir(), new File("d:/test/python/extract/extract.yaml"));
        System.out.println(sshConfig);
    }
}
