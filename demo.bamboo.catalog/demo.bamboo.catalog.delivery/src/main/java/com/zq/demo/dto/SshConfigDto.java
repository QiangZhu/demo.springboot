package com.zq.demo.dto;

public class SshConfigDto {

    private String ip;

    private String port;

    private String user;

    private String password;

    private String targetDir;

    private String sourceFilePaths;

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

    public String getSourceFilePaths() {
        return sourceFilePaths;
    }

    public void setSourceFilePaths(String sourceFilePaths) {
        this.sourceFilePaths = sourceFilePaths;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SshConfigDto{");
        sb.append("ip='").append(ip).append('\'');
        sb.append(", port='").append(port).append('\'');
        sb.append(", user='").append(user).append('\'');
        sb.append(", password='").append("*****").append('\'');
        sb.append(", targetDir='").append(targetDir).append('\'');
        sb.append(", sourceFilePaths='").append(sourceFilePaths).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
