package demo.springboot.cache.redis.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import demo.springboot.cache.redis.entity.MetaDefinition;

public interface MetaDefinitionRepository extends CrudRepository<MetaDefinition, Long> {

	
	@Query(" select t from MetaDefinition t where t.code = :code ")
	MetaDefinition findByCode(@Param(value = "code") String code);

}
