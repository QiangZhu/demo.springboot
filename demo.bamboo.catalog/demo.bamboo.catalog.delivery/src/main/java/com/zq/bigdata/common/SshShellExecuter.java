package com.zq.bigdata.common;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zhuqiang on 2018-09-05.
 */
public class SshShellExecuter {

	private static final int BLOCK_SIZE = 1024;
	private Session session;

	public SshShellExecuter(Session session) {
		this.session = session;
	}

	private ChannelExec openChannelExec(Session session) {
		ChannelExec channelExec = null;
		try {
			Channel channel = session.openChannel("exec");
			channelExec = (ChannelExec) channel;
		} catch (JSchException e) {
			e.printStackTrace();
		}
		return channelExec;
	}

	public String execute(String command) throws IOException, JSchException {
		ChannelExec channelExec = openChannelExec(session);
		StringBuffer buffer = executeCommand(command, channelExec);
		closeChannelExec(channelExec);
		return buffer.toString();
	}

	public void executeWithoutResult(String command) throws IOException, JSchException{
		ChannelExec channelExec = openChannelExec(session);
		channelExec.setCommand(command);
		channelExec.connect();
		closeChannelExec(channelExec);
	}

	private StringBuffer executeCommand(String command, ChannelExec channelExec)
			throws IOException, JSchException {
		InputStream result = channelExec.getInputStream();
		channelExec.setCommand(command);
		channelExec.connect();
		StringBuffer buffer = generateResult(result);
		return buffer;
	}

	private StringBuffer generateResult(InputStream inputStream)
			throws IOException {
		StringBuffer buffer = new StringBuffer();
		byte[] bytes = new byte[BLOCK_SIZE];
		while (inputStream.read(bytes) > 0) {
			buffer.append(new String(bytes));
		}
		return buffer;
	}

	private void closeChannelExec(ChannelExec channelExec) {
		channelExec.disconnect();
	}
}
