package com.zq.bigdata.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
    private String dir;

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

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SshConfig{");
        sb.append("ip='").append(ip).append('\'');
        sb.append(", port='").append(port).append('\'');
        sb.append(", user='").append(user).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", dir='").append(dir).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
