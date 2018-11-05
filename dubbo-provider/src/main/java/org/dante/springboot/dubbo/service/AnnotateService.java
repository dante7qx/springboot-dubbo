package org.dante.springboot.dubbo.service;

import org.dante.springboot.dubbo.api.service.IAnnotateService;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;

@Service(retries = 0, timeout = 5000)
public class AnnotateService implements IAnnotateService {

	@Override
	public String sayHello(String msg) {
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

}
