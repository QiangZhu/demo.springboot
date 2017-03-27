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
 *		   2017年3月20日 下午6:07:59
 *
 */
public class Hotel implements Serializable {

	/**
	 * 
	 * @author YixinCapital -- zq
	 *		   2017年3月20日 下午6:08:25
	 *
	 */
	private static final long serialVersionUID = 6806094939977219719L;
	
	private Long city;

	private String name;

	private String address;

	private String zip;

	public Long getCity() {
		return city;
	}

	public void setCity(Long city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Hotel [city=" + city + ", name=" + name + ", address=" + address + ", zip=" + zip + "]";
	}

}
