package com.efinance.iamUserClient.multitenant;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "tenants")
public class DataSourceProperties {

	private Map<Object, Object> datasources = new LinkedHashMap<>();

	public Map<Object, Object> getDatasources() {
		return datasources;
	}

	public void setDatasources(Map<String, Map<String, String>> dataSources) {
		dataSources.forEach((key, value) -> this.datasources.put(key, convert(value)));
	}

	private DataSource convert(Map<String, String> source) {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create(this.getClass().getClassLoader());
		dataSourceBuilder.driverClassName(source.get("driverClassName"));
		dataSourceBuilder.url(source.get("url"));
		dataSourceBuilder.username(source.get("username"));
		dataSourceBuilder.password(source.get("password"));
		DataSource ds = dataSourceBuilder.build();
		return ds;
	}

}
