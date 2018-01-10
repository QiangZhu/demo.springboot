package demo.app.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;

public class DemoDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5713813997980727070L;
	
	
	//@SafeHtml(whitelistType = WhiteListType.SIMPLE_TEXT)
	@SafeHtml
	private String name;
	
	private String account;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DemoDto [");
		if (name != null) {
			builder.append("name=");
			builder.append(name);
			builder.append(", ");
		}
		if (account != null) {
			builder.append("account=");
			builder.append(account);
		}
		builder.append("]");
		return builder.toString();
	}
}
