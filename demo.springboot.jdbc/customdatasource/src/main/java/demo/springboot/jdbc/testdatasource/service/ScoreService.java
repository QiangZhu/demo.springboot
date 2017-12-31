/**
 * 2017年3月20日
 * zq
 */
package demo.springboot.jdbc.testdatasource.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import demo.springboot.jdbc.testdatasource.core.Score;

/**
 * Package : demo.springboot.jdbc.service
 * 
 * @author YixinCapital -- zq 2017年3月20日 上午10:57:48
 *
 */
public interface ScoreService extends CrudRepository<Score, Integer> {

	@Transactional
	@Modifying
	@Query("update Score t set t.score = :score where t.id = :id")
	int updateScoreById(@Param("score") float score, @Param("id") int id);

	@Query("select t from Score t ")
	List<Score> getList();
}
