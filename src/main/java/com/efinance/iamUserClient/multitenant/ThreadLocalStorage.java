package com.efinance.iamUserClient.multitenant;

public class ThreadLocalStorage {

	private static InheritableThreadLocal<String> tenant = new InheritableThreadLocal<>();

	public static void setTenantName(String tenantName) {
		tenant.set(tenantName);
	}

	public static String getTenantName() {
		return tenant.get();
	}

	public static void clean() {
		tenant.remove();

	}
}
