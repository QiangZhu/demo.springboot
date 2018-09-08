package com.zq.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SshConfig  {

    @Value("${ip}")
    private String ip;

    @Value("${port}")
    private String port;

    @Value("${user}")
    private String user;

    @Value("${password}")
    private String password;

    @Value("${dir}")
    private String targetDir;

    private List<String> sourceFilePaths;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTargetDir() {
        return targetDir;
    }

    public void setTargetDir(String targetDir) {
        this.targetDir = targetDir;
    }

    public List<String> getSourceFilePaths() {
        return sourceFilePaths;
    }

    public void setSourceFilePaths(List<String> sourceFilePaths) {
        this.sourceFilePaths = sourceFilePaths;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SshConfig{");
        sb.append("ip='").append(ip).append('\'');
        sb.append(", port='").append(port).append('\'');
        sb.append(", user='").append(user).append('\'');
        sb.append(", password='").append("******").append('\'');
        sb.append(", targeDir='").append(targetDir).append('\'');
        sb.append(", soourceFilePaths=").append(String.join(", ",sourceFilePaths));
        sb.append('}');
        return sb.toString();
    }
}
