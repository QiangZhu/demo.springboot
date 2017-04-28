/**
 * 2017年4月28日
 * zq
 */
package importxml;

import javax.sql.DataSource;

import org.junit.Assert;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Package : importxml
 * 
 * @author YixinCapital -- zq
 *		   2017年4月28日 下午3:07:06
 *
 */
public class Application {

	/**
	 * 
	 * @param args 
	 * @author YixinCapital -- zq
	 *	       2017年4月28日 下午3:07:06
	 */
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Config.class);
        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        Assert.assertNotNull(dataSource);

	}

}
