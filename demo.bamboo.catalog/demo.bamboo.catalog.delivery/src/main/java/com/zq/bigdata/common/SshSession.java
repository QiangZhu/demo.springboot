package com.zq.bigdata.common;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.util.Properties;

/**
 * Created by zhuqiang on 2018-09-05.
 */
public class SshSession {


	private static final int TIMEOUT = 3000;

	public Session openSession(String username, String password, String host,
							   String port) {
		Session session = null;
		try {
			session = connect(username, password, host, Integer.parseInt(port));
		} catch (JSchException e) {
			System.out.println("[ERROR] " + e.getMessage()
					+ ", check your username and password.");
		}
		return session;
	}

	private Session connect(String username, String password, String host,
							int port) throws JSchException {
		Session session = new JSch().getSession(username, host, port);
		session = skipHostKeyChecking(session);
		session.setPassword(password);
		session.connect(TIMEOUT);
		return session;
	}

	private Session skipHostKeyChecking(Session session) {
		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
		return session;
	}
}
