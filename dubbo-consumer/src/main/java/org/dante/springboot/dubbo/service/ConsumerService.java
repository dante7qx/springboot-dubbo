package org.dante.springboot.dubbo.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

import org.dante.springboot.dubbo.api.service.IAnnotateService;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ConsumerService {
	
	@Reference(loadbalance="roundrobin")
	private IAnnotateService annotateService;
	
	public String sayHello(String msg) {
		
		RpcContext.getContext().setAttachment("accessToken", "消费编号 - ".concat(UUID.randomUUID().toString()));
		try {
			String localAddr = InetAddress.getLocalHost().toString();
			log.info("=====================> {} send request to dubbo provider.", localAddr);
			return annotateService.sayHello(localAddr.concat(" ====> ").concat(msg));
		} catch (UnknownHostException e) {
			log.error("InetAddress.getLocalHost() error.", e);
		}
		return msg;
	}
	
}
