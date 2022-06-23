package com.efinance.iamUserClient.multitenant;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.efinance.iamUserClient.domain.etaxprofile.entities.DueAmount;

@Configuration
public class DataSourceConfig {

	private final DataSourceProperties dataSourceProperties;

	public DataSourceConfig(DataSourceProperties dataSourceProperties) {
		this.dataSourceProperties = dataSourceProperties;
	}

	@Bean
	public DataSource getDataSource() {
		TenantAwareRoutingDataSource tenantAwareRoutingDataSource = new TenantAwareRoutingDataSource();
		tenantAwareRoutingDataSource.setTargetDataSources(dataSourceProperties.getDatasources());
		tenantAwareRoutingDataSource.afterPropertiesSet();
		return tenantAwareRoutingDataSource;
	}
	
	
//	@Bean(name="entityManagerFactory")
//	public LocalSessionFactoryBean sessionFactory() {
//	    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//	    return sessionFactory;
//	} 
	
	@Bean
	public DueAmount getDueAmount() {
		return new DueAmount();
	}

}
