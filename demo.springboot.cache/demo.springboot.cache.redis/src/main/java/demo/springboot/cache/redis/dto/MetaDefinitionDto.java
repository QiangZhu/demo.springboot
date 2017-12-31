package demo.springboot.cache.redis.dto;

import java.io.Serializable;

public class MetaDefinitionDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3167953631175621448L;

	
	private long tid;
	
	private String code;
	
	private String name;

	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MetaDefinitionDto [tid=");
		builder.append(tid);
		builder.append(", ");
		if (code != null) {
			builder.append("code=");
			builder.append(code);
			builder.append(", ");
		}
		if (name != null) {
			builder.append("name=");
			builder.append(name);
		}
		builder.append("]");
		return builder.toString();
	}
}
