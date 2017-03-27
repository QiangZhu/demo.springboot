/**
 * 2017年3月20日
 * zq
 */
package demo.springboot.jdbc.jpa.dto;

import java.util.Date;

/**
 * Package : demo.springboot.jdbc.jpa.dto
 * 
 * @author YixinCapital -- zq
 *		   2017年3月20日 上午11:44:47
 *
 */
public class ScoreDTO {
	
	private int stuId;

	private String subjectName;

	private float score;

	private Date examTime;

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public Date getExamTime() {
		return examTime;
	}

	public void setExamTime(Date examTime) {
		this.examTime = examTime;
	}

}
