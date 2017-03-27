/**
 * 2017年3月20日
 * zq
 */
package demo.springboot.jdbc.hikaripool.dto;

/**
 * Package : demo.springboot.jdbc.hikaripool.dto
 * 
 * @author YixinCapital -- zq
 *		   2017年3月20日 下午3:57:44
 *
 */
public class StudentDTO {
	
	private int id;
	
	private String name;
	
	private String scoreSum;
	
	private String scoreAvg;
	
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

}
