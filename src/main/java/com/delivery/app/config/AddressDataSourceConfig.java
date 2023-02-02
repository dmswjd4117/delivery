package com.delivery.app.config;

import java.util.HashMap;
import javax.inject.Qualifier;
import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.delivery.address"
    , entityManagerFactoryRef = "addressEntityManger"
    , transactionManagerRef = "addressTransactionManger"
)
public class AddressDataSourceConfig {

  @Bean(name = "addressDataSource")
  @ConfigurationProperties(prefix = "spring.address")
  public DataSource datasource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "addressEntityManger")
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(datasource());
    em.setPackagesToScan("com.delivery.address");
    em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

    HashMap<String, Object> properties = new HashMap<>();
    properties.put("hibernate.hbm2ddl.auto", "none");
    properties.put("hibernate.format_sql", "true");
    properties.put("hibernate.use_sql_comments", "true");
    properties.put("hibernate.physical_naming_strategy",
        "org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl");
    em.setJpaPropertyMap(properties);

    return em;
  }


  @Bean(name = "addressTransactionManger")
  @Primary
  public PlatformTransactionManager transactionManager() {
    JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
    jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
    return jpaTransactionManager;
  }
}