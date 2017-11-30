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
	
	private String remark;
	
	private short status;

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
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ScoreDTO [stuId=");
		builder.append(stuId);
		builder.append(", ");
		if (subjectName != null) {
			builder.append("subjectName=");
			builder.append(subjectName);
			builder.append(", ");
		}
		builder.append("score=");
		builder.append(score);
		builder.append(", ");
		if (examTime != null) {
			builder.append("examTime=");
			builder.append(examTime);
			builder.append(", ");
		}
		if (remark != null) {
			builder.append("remark=");
			builder.append(remark);
			builder.append(", ");
		}
		builder.append("status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}

}
