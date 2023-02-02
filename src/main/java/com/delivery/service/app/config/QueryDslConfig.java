package com.delivery.service.app.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueryDslConfig {

  @Autowired
  @Qualifier("mainEntityManger")
  private EntityManager mainEntityManger;

  @Autowired
  @Qualifier("addressEntityManger")
  private EntityManager addressEntityManger;


  @Bean(name = "mainJpaQueryFactory")
  public JPAQueryFactory mainJpaQueryFactory() {
    return new JPAQueryFactory(mainEntityManger);
  }

  @Bean(name = "addressJpaQueryFactory")
  public JPAQueryFactory addressJpaQueryFactory() {
    return new JPAQueryFactory(addressEntityManger);
  }
}
