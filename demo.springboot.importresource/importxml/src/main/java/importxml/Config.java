/**
 * 2017年4月28日
 * zq
 */
package importxml;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Package : importxml
 * 
 * @author YixinCapital -- zq
 *		   2017年4月28日 下午3:07:30
 *
 */
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories
@ComponentScan
@ImportResource("classpath:META-INF/spring/config.xml")
public class Config {
	
	@Autowired
    private DataSource dataSource;

}
