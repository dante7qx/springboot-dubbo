package org.dante.springboot.dubbo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;

@Configuration
public class DubboConfig {
	
	@Value("${zk.address}")
	private String zkAddress;
	
	@Bean
	public ApplicationConfig applicationConfig() {
		ApplicationConfig applicationConfig = new ApplicationConfig();
		applicationConfig.setId("provider-test");
		applicationConfig.setName("provider-test");
		applicationConfig.setLogger("slf4j");
		return applicationConfig;
	}

	@Bean
	public RegistryConfig registryConfig() {
		RegistryConfig registryConfig = new RegistryConfig();
		registryConfig.setAddress("zookeeper://".concat(zkAddress));
		registryConfig.setClient("curator");
		registryConfig.setProtocol("dubbo");
		registryConfig.setPort(20880);
		return registryConfig;
	}
	
	@Bean
	public ProviderConfig providerConfig() {
		ProviderConfig providerConfig = new ProviderConfig();
		providerConfig.setFilter("validationFilter");
		return providerConfig;
	}
}
