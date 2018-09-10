package com.zq.demo.service;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.zq.demo.common.SshFileSender;
import com.zq.demo.common.SshSession;
import com.zq.demo.common.SshShellExecuter;
import com.zq.demo.config.SshConfig;
import com.zq.demo.dto.ExecDto;
import com.zq.demo.dto.FinalDto;
import com.zq.demo.repository.RedisRepository;
import io.netty.util.internal.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class Service {

    private static final Logger logger = LoggerFactory.getLogger(Service.class);
    private static final String PYTHON_NAME = "extract.py";

    @Autowired
    private RedisRepository redisRepository;

    @Autowired
    private SshConfig sshConfig;

    public List<FinalDto> getall() {
        Map<String, String> datas = redisRepository.findAllDemoDatas();
        ConcurrentHashMap<String, SortedSet<String>> map = new ConcurrentHashMap<>();
        Set<String> keyValues = datas.keySet();
        for (String keyValue : keyValues) {
            String[] temp = keyValue.split(",");
            if (temp != null && temp.length >= 2) {
                SortedSet values = null;
                if (map.containsKey(temp[0])) {
                    values = map.get(temp[0]);
                } else {
                    values = new TreeSet<String>();
                }
                values.add(temp[1]);
                map.put(temp[0], values);
            }
        }
        List<FinalDto> result = new ArrayList();
        for (Map.Entry<String, SortedSet<String>> entry : map.entrySet()) {
            FinalDto dto = new FinalDto();
            dto.setKey(entry.getKey());
            List<String> values = new ArrayList<>();
            for (String value : entry.getValue()) {
                values.add(value);
            }
            dto.setValues(values);
            result.add(dto);
        }
        return result;
    }

    public void deliver() throws IOException, JSchException {
        SshSession sshSession = new SshSession();
        Session session = sshSession.openSession(sshConfig.getUser(), sshConfig.getPassword(),
                sshConfig.getIp(), sshConfig.getPort());
        SshFileSender fileSender = new SshFileSender(session);
        for (String filepath : sshConfig.getSourceFilePaths()) {
            boolean isFileUploaded = fileSender.upload(sshConfig.getTargetDir(), new File(filepath));
        }
    }

    public ExecDto execute(ExecDto execDto) throws IOException, JSchException,IllegalStateException{
        SshSession sshSession = new SshSession();
        String ip = StringUtil.isNullOrEmpty(execDto.getIp()) ? sshConfig.getIp() : execDto.getIp();
        String port = StringUtil.isNullOrEmpty(execDto.getPort()) ? sshConfig.getPassword() : execDto.getPort();
        String user = StringUtil.isNullOrEmpty(execDto.getUser()) ? sshConfig.getUser() : execDto.getUser();
        String password = StringUtil.isNullOrEmpty(execDto.getPassord()) ? sshConfig.getPassword()
                : execDto.getPassord() ;
        Session session = sshSession.openSession(user, password, ip, port);
        String pid = getPid(session);
        if(!StringUtil.isNullOrEmpty(pid)){
            throw new IllegalStateException("the extract process is running now");
        }
        SshShellExecuter executer = new SshShellExecuter(session);
        StringBuilder command = new StringBuilder();
        command.append(" cd ").append(sshConfig.getTargetDir()).append(" ; ");
        command.append(" nohup python ").append(PYTHON_NAME)
                .append(" </dev/null >/dev/null 2>&1 & ");
        executer.execute(command.toString());
        execDto.setPid(getPid(session));
        return execDto;
   }

    private String getPid(Session session) throws IOException, JSchException{
        SshShellExecuter executer = new SshShellExecuter(session);
        StringBuilder check = new StringBuilder();
        check.append("ps -ef | grep ").append("\"").append(session.getUserName()).append(".*python ")
                .append(PYTHON_NAME).append("\"");
        String response = executer.execute(check.toString());
        int keyIndex = response.indexOf(PYTHON_NAME);
        String pid = "";
        if (keyIndex != -1 ){
            String s  = response.substring(0,keyIndex);
            int ptsIndex = s.indexOf(" ps -ef");
            if(ptsIndex != -1){
                return null;
            }else {
                String[] lines = s.split("\\n");
                if (lines.length > 0) {
                    String line = lines[0];
                    String[] words = line.split("\\s+");
                    if (words.length > 1) {
                        pid = words[1];
                    }
                }
            }
        }
        return pid;
    }

    public ExecDto cancel(ExecDto execDto) throws IOException, JSchException,IllegalArgumentException{
        SshSession sshSession = new SshSession();
        String ip = StringUtil.isNullOrEmpty(execDto.getIp()) ? sshConfig.getIp() : execDto.getIp();
        String port = StringUtil.isNullOrEmpty(execDto.getPort()) ? sshConfig.getPassword() : execDto.getPort();
        String user = StringUtil.isNullOrEmpty(execDto.getUser()) ? sshConfig.getUser() : execDto.getUser();
        String password = StringUtil.isNullOrEmpty(execDto.getPassord()) ? sshConfig.getPassword()
                : execDto.getPassord() ;
        Session session = sshSession.openSession(user, password, ip, port);
        SshShellExecuter executer = null;
        executer = new SshShellExecuter(session);
        StringBuilder command = new StringBuilder();
        if(!StringUtil.isNullOrEmpty(execDto.getPid())){
            command.append(" ps -ef | grep 'python ").append(PYTHON_NAME).append("' ");
            String response = executer.execute(command.toString());
            if(execDto.getPid().equals(getPid(session))) {
                command.append(" kill -9  ").append(execDto.getPid());
            }else{
                throw new IllegalArgumentException(" the process is not existed");
            }
        }else{
            throw new IllegalArgumentException(" arguremnt is Illegal");
        }
        return execDto;
    }
}
