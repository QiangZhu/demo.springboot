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


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DemoDto [name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

}
