package org.dante.springboot.dubbo.service;

import java.util.UUID;

import org.dante.springboot.dubbo.api.service.IAnnotateService;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;

@Service
public class ConsumerService {
	
	@Reference
	private IAnnotateService annotateService;
	
	public String sayHello(String msg) {
		RpcContext.getContext().setAttachment("accessToken", "消费编号 - ".concat(UUID.randomUUID().toString()));
		return annotateService.sayHello(msg);
	}
}
