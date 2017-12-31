package demo.springboot.cache.redis.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import demo.springboot.cache.redis.assembler.Assembler;
import demo.springboot.cache.redis.dto.MetaDefinitionDto;
import demo.springboot.cache.redis.entity.MetaDefinition;
import demo.springboot.cache.redis.repository.MetaDefinitionRepository;
import demo.springboot.cache.redis.service.MetaDefinitionService;
@Service("metaDefinitionService")
public class MetaDefinitionServiceImpl implements MetaDefinitionService {
	
	@Autowired
	private MetaDefinitionRepository metaDefinitionRepository;

	@Transactional
	@Override
	public MetaDefinitionDto create(MetaDefinitionDto dto) {
		MetaDefinition entity = Assembler.toEntity(dto);
		return Assembler.toDto(metaDefinitionRepository.save(entity));
	}

	@Cacheable(value = "MetaDefinitionDto", key = "#dto.code")
	@Override
	public MetaDefinitionDto findByCode(MetaDefinitionDto dto) {
		MetaDefinition entity = Assembler.toEntity(dto);
		return Assembler.toDto(metaDefinitionRepository.findByCode(dto.getCode()));
	}

	@CachePut(value = "MetaDefinitionDto", key = "#dto.code")
	@Transactional
	@Override
	public MetaDefinitionDto update(MetaDefinitionDto dto) {
		MetaDefinition entity = metaDefinitionRepository.findByCode(dto.getCode());
		entity.setName(dto.getName());
		return Assembler.toDto(metaDefinitionRepository.save(entity));
	}

	@CacheEvict(value = "MetaDefinitionDto", key = "#dto.code")
	@Override
	public MetaDefinitionDto delete(MetaDefinitionDto dto) {
		MetaDefinition entity = metaDefinitionRepository.findByCode(dto.getCode());
		metaDefinitionRepository.delete(entity);
		return Assembler.toDto(entity);
	}
	
	@CacheEvict(value = "MetaDefinitionDto", allEntries = true)
	@Override
	public void clearCache() {
		System.out.println("clear cache");
	}

}
