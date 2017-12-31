package demo.springboot.cache.redis.assembler;

import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;

import demo.springboot.cache.redis.dto.MetaDefinitionDto;
import demo.springboot.cache.redis.entity.MetaDefinition;

public class Assembler {
	
	public static MetaDefinition toEntity(MetaDefinitionDto dto) {
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
		return mapper.map(dto, MetaDefinition.class);
	}
	
	public static MetaDefinitionDto toDto(MetaDefinition entity) {
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
		return mapper.map(entity, MetaDefinitionDto.class);
	}
}
