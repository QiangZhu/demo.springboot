/**
 * 2017年3月20日
 * zq
 */
package demo.springboot.jdbc.jpa.core;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Package : demo.springboot.jdbc.core
 * 
 * @author YixinCapital -- zq 2017年3月20日 上午10:58:45
 *
 */
@Entity
@Table(name = "score")
public class Score implements Serializable {

	/**
	 * 
	 * @author YixinCapital -- zq 2017年3月20日 上午10:59:08
	 *
	 */
	private static final long serialVersionUID = -5178745291856714609L;

	@Id
	@GeneratedValue
	private int id;

	/**
	 * 这里说一下，我使用指定数据库列的时候，使用小写会不起作用，
	 * 修改为大写便正常了。不知道为何，如果遇到一样问题的可以尝试下。
	 */
	@Column(nullable = false, name = "STUDENTID") 
	private int stuId;

	@Column(nullable = false, name = "SUBJECTNAME")
	private String subjectName;

	@Column(nullable = false)
	private float score;

	@Column(nullable = false, name = "EXAMTIME")
	private Date examTime;
	
	@Column(nullable = false, name = "REMARK")
	private String remark;
	
	@Column(nullable = false, name = "STATUS")
	private short status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
		builder.append("Score [id=");
		builder.append(id);
		builder.append(", stuId=");
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
