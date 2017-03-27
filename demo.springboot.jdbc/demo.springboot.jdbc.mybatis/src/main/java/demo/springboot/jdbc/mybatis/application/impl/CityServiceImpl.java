/**
 * 2017年3月20日
 * zq
 */
package demo.springboot.jdbc.mybatis.application.impl;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import demo.springboot.jdbc.mybatis.core.City;

/**
 * Package : demo.springboot.jdbc.mybatis.application.impl
 * 
 * @author YixinCapital -- zq 2017年3月20日 下午5:55:42
 *
 */
@Component(value="cityService")
public class CityServiceImpl {

	private final SqlSession sqlSession;

	public CityServiceImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public City selectCityById(long id) {
		return this.sqlSession.selectOne("selectCityById", id);
	}

}
