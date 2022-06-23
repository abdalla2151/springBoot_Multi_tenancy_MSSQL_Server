package com.efinance.iamUserClient.multitenant;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

//@Component
public class TenantAwareRoutingDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		String name = ThreadLocalStorage.getTenantName();
		return name;
	}
}

