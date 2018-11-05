package org.dante.springboot.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

/**
 * docker run -d --name dub-consumer -p 8802:8802 -e zk_address=192.168.1.4:2181 <Your Image>
 * 
 * @author dante
 *
 */
@SpringBootApplication
@EnableDubboConfiguration
public class DubboConsumerApplication {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DubboConsumerApplication.class, args);
	}
	
}
