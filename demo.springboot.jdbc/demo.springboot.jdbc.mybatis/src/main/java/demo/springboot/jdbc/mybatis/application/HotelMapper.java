package demo.springboot.jdbc.mybatis.application;

import org.apache.ibatis.annotations.Mapper;

import demo.springboot.jdbc.mybatis.core.Hotel;

@Mapper
public interface HotelMapper {

	Hotel selectByCityId(int city_id);
}
