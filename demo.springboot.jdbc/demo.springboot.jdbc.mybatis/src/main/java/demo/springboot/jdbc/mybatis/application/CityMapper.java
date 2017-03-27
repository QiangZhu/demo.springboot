package demo.springboot.jdbc.mybatis.application;

import org.apache.ibatis.annotations.Mapper;

import demo.springboot.jdbc.mybatis.core.City;

@Mapper
public interface CityMapper {

	City selectByCityId(int city_id);
}
