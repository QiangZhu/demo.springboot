/**
 * 2017年3月20日
 * zq
 */
package demo.springboot.jdbc.testdatasource.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;

import demo.springboot.jdbc.testdatasource.core.Score;
import demo.springboot.jdbc.testdatasource.dto.ScoreDTO;
import demo.springboot.jdbc.testdatasource.service.ScoreService;


/**
 * Package : demo.springboot.jdbc.jpa.controller
 * 
 * @author YixinCapital -- zq 2017年3月20日 上午11:06:10
 *
 */
@RestController
@RequestMapping("/score")
public class ScoreController {

	private static final Logger logger = LoggerFactory.getLogger(ScoreController.class);

	@Autowired
	private ScoreService scoreService;

	@RequestMapping(value="/l")
	public List<Score> getScoreList() {
		logger.info("从数据库读取Score集合");
		// 测试更新数据库
		//logger.info("更新的行数：" + scoreService.updateScoreById(88.8f, 2));
		return scoreService.getList();
	}
	
	@RequestMapping(value = "/i")
	public Score insert(@RequestBody ScoreDTO scoreDto){
		return scoreService.save(convert(scoreDto));
	}
	
	@RequestMapping("/u")
	public Score update(@RequestBody ScoreDTO scoreDto){
		return scoreService.save(convert(scoreDto));
	}
	
	@RequestMapping("/d")
	public Integer update(Integer id){
		 scoreService.delete(id);
		 return id;
	}
	
	private Score convert(ScoreDTO scoreDto){
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.convertValue(scoreDto, Score.class);
	}

}
