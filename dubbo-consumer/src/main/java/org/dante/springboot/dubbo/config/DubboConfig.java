package org.dante.springboot.dubbo.config;

//@Configuration
public class DubboConfig {
	
//	@Value("${zk.appName}")
//	private String appName;
//	@Value("${zk.address}")
//	private String zkAddress;
//	@Value("${zk.qosPort}")
//	private int qosPort;
	
	// Java 配置
	/**
	@Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setId(appName);
        applicationConfig.setName(appName);
        applicationConfig.setLogger("slf4j");
        applicationConfig.setQosPort(qosPort);
        return applicationConfig;
    }
	*/
	
	// Java 配置
	/**
    @Bean
    public ConsumerConfig consumerConfig() {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setTimeout(3000);
        consumerConfig.setRetries(2);
        return consumerConfig;
    }
    */

	// Java 配置
	/**
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress(zkAddress);
        registryConfig.setClient("curator");
        return registryConfig;
    }
    */
    
}
