/**
 * 2017年3月19日
 * zq
 */
package demo.springboot.jdbc.simple.dto;

import java.io.Serializable;

import org.springframework.stereotype.Service;

/**
 * Package : demo.springboot.jdbc.simple.dto
 * 
 * @author YixinCapital -- zq 2017年3月19日 下午8:25:55
 *
 */
@Service
public class Student implements Serializable {

	/**
	 * 
	 * @author YixinCapital -- zq 2017年3月19日 下午8:26:27
	 *
	 */
	private static final long serialVersionUID = -184894224266856709L;

	private int id;
	private String name;
	private String sumScore;
	private String avgScore;
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSumScore() {
		return sumScore;
	}

	public void setSumScore(String sumScore) {
		this.sumScore = sumScore;
	}

	public String getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(String avgScore) {
		this.avgScore = avgScore;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
