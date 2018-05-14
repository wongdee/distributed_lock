package com.wongdee.lock.util;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

@Configuration
@MapperScan(basePackages="com.wongdee.*.domain")
public class DataSourceConfig {
	
	private DruidDataSource dataSource;

	@Bean(name="dataSource", destroyMethod="close")
	@ConfigurationProperties("spring.datasource")
	public DataSource getDataSource(){
		dataSource = new DruidDataSourceBuilder().build();
		return dataSource;
	}
	
	@PreDestroy
	public void close() {
		if(dataSource != null){
			dataSource.close();
		}
	}
	
}
