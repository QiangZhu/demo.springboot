/**
 * 2017年3月20日
 * zq
 */
package demo.springboot.jdbc.hikaripool.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Package : demo.springboot.jdbc.hikaripool.core
 * 
 * @author YixinCapital -- zq
 *		   2017年3月20日 下午3:51:06
 *
 */
@Entity
@Table(name = "student")
public class Student implements Serializable{

	/**
	 * 
	 * @author YixinCapital -- zq
	 *		   2017年3月20日 下午3:52:17
	 *
	 */
	private static final long serialVersionUID = 5260035902094552401L;
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable=false, name="NAME")
	private String name;
	
	@Column(nullable=false, name="SCORE_SUM")
	private String scoreSum;
	
	@Column(nullable=false, name="SCORE_AVG")
	private String scoreAvg;
	
	@Column(nullable=false, name="AGE")
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

	public String getScoreSum() {
		return scoreSum;
	}

	public void setScoreSum(String scoreSum) {
		this.scoreSum = scoreSum;
	}

	public String getScoreAvg() {
		return scoreAvg;
	}

	public void setScoreAvg(String scoreAvg) {
		this.scoreAvg = scoreAvg;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", scoreSum=" + scoreSum + ", scoreAvg=" + scoreAvg + ", age="
				+ age + "]";
	}
	
}
