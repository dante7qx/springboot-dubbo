package org.dante.springboot.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

/**
 * docker run -d --name dub-provider -p 8801:8801 -e zk_address=192.168.1.4:2181 <Your Image>
 * DUBBO_IP_TO_REGISTRY - 注册到注册中心的IP
 * DUBBO_PORT_TO_REGISTRY - 注册到注册中心的端口
 * 
 * @author dante
 *
 */
@SpringBootApplication
@EnableDubboConfiguration
public class DubboProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboProviderApplication.class, args).start();
		
		/*
		 try {
			// 按任意键退出
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		*/
	}
}
