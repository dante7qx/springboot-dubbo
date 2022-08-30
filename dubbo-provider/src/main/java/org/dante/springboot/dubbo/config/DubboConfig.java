package org.dante.springboot.dubbo.config;

import org.apache.dubbo.config.ProtocolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfig {

	@Value("${server.port}")
	private int hessianPort;
	@Value("${server.servlet.context-path}")
	private String contextpath;

	// Java 配置方式
	/**
	@Bean(name="dubbo")
	public ProtocolConfig dubboProtocolConfig() {
		ProtocolConfig protocolConfig = new ProtocolConfig();
		protocolConfig.setName("dubbo");
		protocolConfig.setPort(zkDubbo);
		return protocolConfig;
	}
	*/
	
	// Java 配置方式
	@Bean(name="hession")
	public ProtocolConfig hessianProtocolConfig() {
		ProtocolConfig protocolConfig = new ProtocolConfig();
		protocolConfig.setName("hessian");
		protocolConfig.setPort(hessianPort);
		protocolConfig.setServer("servlet");
		protocolConfig.setContextpath(contextpath);
		protocolConfig.setSerialization("hessian2");
		return protocolConfig;
	}

	// Java 配置方式
	/**
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
	*/

}
