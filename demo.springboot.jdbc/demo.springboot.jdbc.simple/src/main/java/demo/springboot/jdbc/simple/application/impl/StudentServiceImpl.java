/**
 * 2017年3月19日
 * zq
 */
package demo.springboot.jdbc.simple.application.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import demo.springboot.jdbc.simple.dto.Student;

/**
 * Package : com.springboot.jdbc.simple.application.impl
 * 
 * @author YixinCapital -- zq 2017年3月19日 下午8:29:24
 *
 */
@Service(value="studentService")
public class StudentServiceImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Student> getList() {
		String sql = "SELECT ID,NAME,SCORE_SUM,SCORE_AVG, AGE   FROM STUDENT";
		return (List<Student>) jdbcTemplate.query(sql, new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student stu = new Student();
				stu.setId(rs.getInt("ID"));
				stu.setAge(rs.getInt("AGE"));
				stu.setName(rs.getString("NAME"));
				stu.setSumScore(rs.getString("SCORE_SUM"));
				stu.setAvgScore(rs.getString("SCORE_AVG"));
				return stu;
			}

		});
	}

}
