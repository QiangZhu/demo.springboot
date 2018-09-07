package com.zq.bigdata.service;

import com.jcraft.jsch.Session;
import com.zq.bigdata.common.SshFileSender;
import com.zq.bigdata.common.SshSession;
import com.zq.bigdata.common.SshShellExecuter;
import com.zq.bigdata.config.SshConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class DeliveryService {

    private static final String PYTHON_NAME = "extract.py";

    @Autowired
    private SshConfig sshConfig;

    public void deliver(){
        SshSession  sshSession = new SshSession();
        Session session = sshSession.openSession(sshConfig.getUser(), sshConfig.getPassword(),
                sshConfig.getIp(),sshConfig.getPort());
        SshFileSender fileSender = new SshFileSender(session);
        for (String filepath : sshConfig.getSourceFilePaths()) {
            boolean isFileUploaded = fileSender.upload(sshConfig.getTargetDir(), new File(filepath));
        }
        SshShellExecuter executer = null ;
        try {
            executer = new SshShellExecuter(session);
            StringBuilder command = new StringBuilder();
            command.append(" cd ").append(sshConfig.getTargetDir()).append(" ; ");
            command.append(" nohup python ").append(PYTHON_NAME)
                    .append(" </dev/null >/dev/null 2>&1 & ");
            executer.executeWithoutResult(command.toString());
            System.out.println(command.toString());
        }catch(Exception e) {

        }
    }
}
