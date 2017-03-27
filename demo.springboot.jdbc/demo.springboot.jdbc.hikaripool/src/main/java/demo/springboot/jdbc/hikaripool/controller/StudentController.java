/**
 * 2017年3月20日
 * zq
 */
package demo.springboot.jdbc.hikaripool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.springboot.jdbc.hikaripool.application.StudentService;
import demo.springboot.jdbc.hikaripool.core.Student;
import demo.springboot.jdbc.hikaripool.dto.StudentDTO;

/**
 * Package : demo.springboot.jdbc.hikaripool.controller
 * 
 * @author YixinCapital -- zq
 *		   2017年3月20日 下午4:03:48
 *
 */
@RestController
@RequestMapping(value="/stu")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	
	@RequestMapping(value="/list")
	public List<Student> list(){
		return studentService.getList();
	}
	
	
	
}
