/**
 * 2017年4月28日
 * zq
 */
package importxml;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Package : importxml
 * 
 * @author YixinCapital -- zq
 *		   2017年4月28日 下午3:49:51
 *
 */
public class BarService {

	private DataSource dataSource;
	
	private static final Logger logger = LoggerFactory.getLogger(BarService.class);

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void init() {
        Assert.assertNotNull(dataSource);
        logger.info("--------------------->datasource class name is :"+dataSource.getClass().getName());
    }
}
