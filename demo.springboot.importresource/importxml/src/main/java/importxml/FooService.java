/**
 * 2017年4月28日
 * zq
 */
package importxml;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Package : importxml
 * 
 * @author YixinCapital -- zq 2017年4月28日 下午3:51:33
 *
 */
@Service
public class FooService {

	@Autowired
	DataSource dataSource;

	@PostConstruct
	public void init() {
		Assert.assertNotNull(dataSource);
		
	}
}
