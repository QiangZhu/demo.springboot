/**
 * 2017年3月19日
 * zq
 */
package demo.springboot.jdbc.tomcatdbcppool.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.springboot.jdbc.tomcatdbcppool.application.impl.StudentServiceImpl;
import demo.springboot.jdbc.tomcatdbcppool.dto.Student;

/**
 * Package : com.springboot.jdbc.simple.controller
 * 
 * @author YixinCapital -- zq 2017年3月19日 下午8:31:12
 *
 */
@RestController
@RequestMapping("/stu")
public class StudentController {

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentServiceImpl studentService;

	@RequestMapping("/list")
	public List<Student> getStus() {
		logger.info("从数据库读取Student集合");
		return studentService.getList();
	}

}
