package com.delivery.service.app.config;

import com.delivery.service.address.infrastructure.AddressRepository;
import java.util.HashMap;
import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.delivery.service.app"
    , entityManagerFactoryRef = "mainEntityManger"
    , transactionManagerRef = "mainTransactionManger"
    , excludeFilters = {
    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {AddressRepository.class})
}
)
public class MainDataSourceConfig {

  @Bean(name = "mainDataSource")
  @ConfigurationProperties(prefix = "spring.main")
  public DataSource datasource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "mainEntityManger")
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(datasource());
    em.setPackagesToScan("com.delivery.service.app");
    em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

    HashMap<String, Object> properties = new HashMap<>();
    properties.put("hibernate.hbm2ddl.auto", "create");
    properties.put("hibernate.format_sql", "true");
    properties.put("hibernate.use_sql_comments", "true");
    properties.put("hibernate.physical_naming_strategy",
        "org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy");
    em.setJpaPropertyMap(properties);

    return em;
  }


  @Bean(name = "mainTransactionManger")
  public PlatformTransactionManager transactionManager() {
    JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
    jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
    return jpaTransactionManager;
  }
}