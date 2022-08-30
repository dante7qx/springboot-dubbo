package org.dante.springboot.dubbo.filter;


import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.Filter;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.RpcException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Activate
public class ValidationFilter implements Filter {

	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		String accessToken = RpcContext.getContext().getAttachment("accessToken");
		log.info("AccessToken({}) ======> {}", accessToken);
//		if(accessToken.length() < 32) {
//			return new RpcResult(new Exception(accessToken.concat("没有访问权限")));
//		}
		return invoker.invoke(invocation);
	}

}
