package demo.springboot.jdbc.customdatasource;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
public class TestDataSourceConfig {
  
  @Bean
  @ConfigurationProperties(prefix = "study.springboot.test.datasource")
  public DataSource dataSource() {
	DataSource dataSource = DataSourceBuilder.create().build();
    return dataSource;
  }

  @Bean
  public EntityManagerFactory testEntityManagerFactory() {
    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    vendorAdapter.setGenerateDdl(true);
    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    factory.setDataSource(dataSource());
    factory.setPackagesToScan("demo.springboot.jdbc.testdatasource.core");
    factory.setPersistenceUnitName("test");
    factory.setJpaVendorAdapter(vendorAdapter);
    factory.afterPropertiesSet();
    return factory.getObject();
  }

//  @Bean
//  public PlatformTransactionManager testTransactionManager() {
//    JpaTransactionManager txManager = new JpaTransactionManager();
//   // txManager.setEntityManagerFactory(testEntityManagerFactory());
//    return txManager;
//  }
}
