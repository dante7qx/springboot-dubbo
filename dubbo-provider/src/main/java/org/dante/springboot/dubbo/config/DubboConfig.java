package org.dante.springboot.dubbo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;

@Configuration
public class DubboConfig {

	@Value("${zk.address}")
	private String zkAddress;
	@Value("${zk.dubbo}")
	private int zkDubbo;
	@Value("${zk.hessian}")
	private int zkHessian;
	@Value("${zk.qos}")
	private int zkQos;

	@Bean
	public ApplicationConfig applicationConfig() {
		ApplicationConfig applicationConfig = new ApplicationConfig();
		applicationConfig.setId("provider-test");
		applicationConfig.setName("provider-test");
		applicationConfig.setQosPort(zkQos);
		applicationConfig.setLogger("slf4j");
		return applicationConfig;
	}

	@Bean
	public RegistryConfig registryConfig() {
		RegistryConfig registryConfig = new RegistryConfig();
		registryConfig.setProtocol("zookeeper");
		registryConfig.setAddress(zkAddress);
		registryConfig.setClient("curator");
		return registryConfig;
	}

	@Bean(name="dubbo")
	public ProtocolConfig dubboProtocolConfig() {
		ProtocolConfig protocolConfig = new ProtocolConfig();
		protocolConfig.setName("dubbo");
		protocolConfig.setPort(zkDubbo);
		return protocolConfig;
	}
	
	@Bean(name="hessian")
	public ProtocolConfig hessianProtocolConfig() {
		ProtocolConfig protocolConfig = new ProtocolConfig();
		protocolConfig.setName("hessian");
		protocolConfig.setPort(zkHessian);
		protocolConfig.setServer("servlet");
		protocolConfig.setContextpath("/provider/hessian");
		return protocolConfig;
	}

	@Bean
	public ProviderConfig providerConfig() {
		ProviderConfig providerConfig = new ProviderConfig();
		List<ProtocolConfig> protocols = new ArrayList<>();
		protocols.add(dubboProtocolConfig());
		protocols.add(hessianProtocolConfig());
		providerConfig.setProtocols(protocols);
		providerConfig.setFilter("validationFilter");
		return providerConfig;
	}

}
