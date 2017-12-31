package demo.springboot.cache.redis.service;

import demo.springboot.cache.redis.dto.MetaDefinitionDto;

public interface MetaDefinitionService {

	MetaDefinitionDto create(MetaDefinitionDto dto);

	MetaDefinitionDto findByCode(MetaDefinitionDto dto);

	MetaDefinitionDto update(MetaDefinitionDto dto);

	MetaDefinitionDto delete(MetaDefinitionDto dto);

	void clearCache();

}
