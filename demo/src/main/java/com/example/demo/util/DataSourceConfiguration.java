package com.example.demo.util;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.demo.dao.BoardDao;
import com.example.demo.dao.CommentDao;
import com.example.demo.dao.MemberDao;

@Configuration
public class DataSourceConfiguration {

	@Primary
	@Bean(name="testDataSource")
	@ConfigurationProperties(prefix="danawa.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().type(BasicDataSource.class).build();
	}

	@Primary
	@Bean(name="testSqlSessionFactory")
	public SqlSessionFactory testSqlSessionFactory(@Autowired @Qualifier("testDataSource") DataSource dataSource, ApplicationContext applicationContext) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mapper/mysql-config.xml"));
		return sqlSessionFactoryBean.getObject();
	}

	@Primary
	@Bean(name="testSqlSessionTemplate")
	public SqlSessionTemplate testSqlSessionTemplate(@Autowired @Qualifier("testSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	@Bean
	@SuppressWarnings("resource")
	public CommentDao CommentDao(@Autowired @Qualifier("testSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
		return sessionTemplate.getMapper(CommentDao.class);
	}
	
	@Bean
	@SuppressWarnings("resource")
	public BoardDao BoardDao(@Autowired @Qualifier("testSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
		return sessionTemplate.getMapper(BoardDao.class);
	}
	
	
	@Bean
	@SuppressWarnings("resource")
	public MemberDao MemberDao(@Autowired @Qualifier("testSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
		return sessionTemplate.getMapper(MemberDao.class);
	}

}
