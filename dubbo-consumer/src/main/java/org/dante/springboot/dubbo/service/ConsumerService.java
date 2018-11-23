package org.dante.springboot.dubbo.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.UUID;

import org.dante.springboot.dubbo.api.service.IAnnotateService;
import org.dante.springboot.dubbo.api.service.IRestfulService;
import org.dante.springboot.dubbo.api.vo.UserVO;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ConsumerService {

	@Reference(loadbalance = "random")
	private IAnnotateService annotateService;

	@Reference(timeout = 2000)
	private IRestfulService restfulService;

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

	public String delay(int delay) {
		return annotateService.delay(delay);
	}
	
	public void register(UserVO usrVO) {
		restfulService.register(usrVO);
	}

	public List<UserVO> findUsers() {
		return restfulService.findUsers();
	}
}
