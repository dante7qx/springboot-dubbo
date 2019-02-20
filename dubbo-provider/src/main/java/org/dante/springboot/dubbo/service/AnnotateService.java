package org.dante.springboot.dubbo.service;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.dante.springboot.dubbo.api.service.IAnnotateService;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(retries = 0, timeout = 5000, loadbalance = "roundrobin", protocol="dubbo")
public class AnnotateService implements IAnnotateService {

	@Override
	public String sayHello(String msg) {
		try {
			String localAddr = InetAddress.getLocalHost().toString();
			log.info("{} receive request {}", localAddr, msg);
		} catch (UnknownHostException e) {
			log.error("InetAddress.getLocalHost error.", e);
		}

		log.info(msg);
		RpcContext context = RpcContext.getContext();
		String localAddress = context.getLocalAddressString();
		String remoteAddress = context.getRemoteAddressString();
		String accessToken = context.getAttachment("accessToken");
		String clientIP = context.getRemoteHost();
		String appName = context.getUrl().getParameter("application");
		StringBuffer buf = new StringBuffer();
		buf.append("生产者 [").append("\n").append("消费者：").append(appName).append(" — ").append(clientIP).append(" | ")
				.append("Msg：").append(msg).append(" | ").append("AccessToken：").append(accessToken).append(" ]");
		buf.append("<br>");
		buf.append("RemoteAddress：").append(remoteAddress).append("<br>");
		buf.append("LocalAddress：").append(localAddress);

		return buf.toString();
	}

	@Override
	public String delay(int delay) {
		try {
			Thread.sleep(delay * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return RpcContext.getContext().getLocalHost() + RpcContext.getContext().getLocalPort() + "Sleep " + delay + "秒";
	}

}
