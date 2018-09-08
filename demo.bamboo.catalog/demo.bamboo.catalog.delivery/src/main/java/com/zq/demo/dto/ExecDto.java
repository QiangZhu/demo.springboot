package com.zq.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExecDto {

    private String ip;
    private String port;
    private String user;
    private String passord;
    private String pid;

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

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ExecDto{");
        sb.append("ip='").append(ip).append('\'');
        sb.append(", port='").append(port).append('\'');
        sb.append(", user='").append(user).append('\'');
        sb.append(", passord='").append("******").append('\'');
        sb.append(", pid='").append(pid).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
