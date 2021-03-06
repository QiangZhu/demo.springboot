/**
 * 2017年3月20日
 * zq
 */
package demo.springboot.jdbc.mybatis.core;

import java.io.Serializable;

/**
 * Package : demo.springboot.jdbc.mybatis.core
 * 
 * @author YixinCapital -- zq
 *		   2017年3月20日 下午6:02:26
 *
 */
public class City implements Serializable {

	/**
	 * 
	 * @author YixinCapital -- zq
	 *		   2017年3月20日 下午6:02:39
	 *
	 */
	private static final long serialVersionUID = -5864044214304144676L;
	
	private Long id;

	private String name;

	private String state;

	private String country;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", state=" + state + ", country=" + country + "]";
	}

}
