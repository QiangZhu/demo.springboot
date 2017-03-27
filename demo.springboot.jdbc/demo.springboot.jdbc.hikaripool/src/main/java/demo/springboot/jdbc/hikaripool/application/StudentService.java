package demo.springboot.jdbc.hikaripool.application;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import demo.springboot.jdbc.hikaripool.core.Student;

public interface StudentService extends CrudRepository<Student, Integer> {
	
	
	@Query("select t from Student t ")
	List<Student> getList();

}
