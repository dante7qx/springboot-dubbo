package org.dante.springboot.dubbo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;

/**
 * docker run -d --name dub-provider -p 8801:8801 -e zk_address=192.168.1.4:2181
 * <Your Image> DUBBO_IP_TO_REGISTRY - 注册到注册中心的IP DUBBO_PORT_TO_REGISTRY -
 * 注册到注册中心的端口
 * 
 * @author dante
 *
 */
@SpringBootApplication
@DubboComponentScan(basePackages = "org.dante.springboot.dubbo.service")
public class DubboProviderApplication {

	public static void main(String[] args) {
		/*
		SpringApplication.run(DubboProviderApplication.class, args).start();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			while (!"exit".equals(str)) {
				str = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		*/
		SpringApplication.run(DubboProviderApplication.class, args);
	}
}
