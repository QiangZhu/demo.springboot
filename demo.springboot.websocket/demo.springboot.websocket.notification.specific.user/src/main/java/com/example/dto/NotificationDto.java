package com.example.dto;

import javax.validation.constraints.NotNull;

/**
 * Created by zhuqiang on 2018-01-27.
 */
public class NotificationDto {

	@NotNull
	private  String domainAccount;

	private String content;

	public String getDomainAccount() {
		return domainAccount;
	}

	public void setDomainAccount(String domainAccount) {
		this.domainAccount = domainAccount;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("NotificationDto{");
		sb.append("domainAccount='").append(domainAccount).append('\'');
		sb.append(", content='").append(content).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
