package org.dante.springboot.dubbo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.RegistryConfig;

@Configuration
public class DubboConfig {
	
	@Value("${zk.appName}")
	private String appName;
	
	@Value("${zk.address}")
	private String zkAddress;
	
	@Value("${zk.qosPort}")
	private int qosPort;
	
	@Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setId(appName);
        applicationConfig.setName(appName);
        applicationConfig.setLogger("slf4j");
        applicationConfig.setQosPort(qosPort);
        return applicationConfig;
    }

    @Bean
    public ConsumerConfig consumerConfig() {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setTimeout(3000);
        consumerConfig.setRetries(2);
        return consumerConfig;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress(zkAddress);
        registryConfig.setClient("curator");
        return registryConfig;
    }
    
}
