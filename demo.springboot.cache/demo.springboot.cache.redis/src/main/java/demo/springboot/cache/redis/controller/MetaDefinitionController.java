package demo.springboot.cache.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import demo.springboot.cache.redis.dto.MetaDefinitionDto;
import demo.springboot.cache.redis.service.MetaDefinitionService;

@RestController
@RequestMapping("/meta/definition")
public class MetaDefinitionController {
	
	@Autowired
	private MetaDefinitionService metaDefinitionService;
	
	
	@RequestMapping( path = "/create")
	public  MetaDefinitionDto create(@RequestBody MetaDefinitionDto dto){
		return metaDefinitionService.create(dto);
	}
	
	@RequestMapping( path = "/findbycode")
	public MetaDefinitionDto findByCode(@RequestBody MetaDefinitionDto dto) {
		return metaDefinitionService.findByCode(dto);
	}
	
	@RequestMapping( path = "/update")
	public MetaDefinitionDto update(@RequestBody MetaDefinitionDto dto) {
		return metaDefinitionService.update(dto);
	}
	
	@RequestMapping( path = "/delete")
	public MetaDefinitionDto delete(@RequestBody MetaDefinitionDto dto) {
		return metaDefinitionService.delete(dto);
	}
	
	@RequestMapping( path = "/clearcache")
	public void clearCache() {
		metaDefinitionService.clearCache();
	}

}
