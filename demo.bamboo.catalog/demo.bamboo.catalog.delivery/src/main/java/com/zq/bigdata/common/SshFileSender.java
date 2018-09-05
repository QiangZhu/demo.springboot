package com.zq.bigdata.common;

import com.jcraft.jsch.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.Vector;

/**
 * Created by zhuqiang on 2018-09-05.
 */
public class SshFileSender {

	private Session session;

	public SshFileSender(Session session) {
		this.session = session;
	}

	public ChannelSftp openChannelSftp(Session session) {
		ChannelSftp channelSftp = null;
		try {
			Channel channel = session.openChannel("sftp");
			channel.connect();
			channelSftp = (ChannelSftp) channel;
		} catch (JSchException e) {
			e.printStackTrace();
		}
		return channelSftp;
	}

	public boolean isChangeedDirectory(String path, ChannelSftp channelSftp) {
		try {
			channelSftp.cd(path);
			return true;
		} catch (Exception e) {
			System.out.println("[ERROR] " + path + ": No such directory");
		}
		return false;
	}

	public boolean upload(String directory, File uploadFile) {
		boolean isUploaded = false;
		ChannelSftp channelSftp = openChannelSftp(session);
		if (isChangeedDirectory(directory, channelSftp)) {
			isUploaded = uploadFile(directory, uploadFile, channelSftp);
		}
		return isUploaded;
	}

	private boolean uploadFile(String directory, File uploadFile,
							   ChannelSftp channelSftp) {
		boolean isUploadedFile = false;
		try {
			channelSftp.put(new FileInputStream(uploadFile),
					uploadFile.getName());
			isUploadedFile = isFileUploaded(directory, uploadFile, channelSftp);
		} catch (Exception e) {
			System.out.println("[ERROR] " + e.getMessage());
		}
		return isUploadedFile;
	}

	@SuppressWarnings("unchecked")
	private boolean isFileUploaded(String directory, File uploadFile,
								   ChannelSftp channelSftp) throws SftpException {
		boolean isFileUploaded = false;
		Vector<ChannelSftp.LsEntry> files = channelSftp.ls(directory);
		for (ChannelSftp.LsEntry file : files) {
			isFileUploaded |= isFileExist(uploadFile, file);
		}
		return isFileUploaded;
	}

	private boolean isFileExist(File uploadFile, ChannelSftp.LsEntry file) {
		return uploadFile.getName().equals(file.getFilename()) ? true : false;
	}
}
