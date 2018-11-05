package org.dante.springboot.dubbo.filter;

import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.RpcResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Activate
public class ValidationFilter implements Filter {

	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		String accessToken = RpcContext.getContext().getAttachment("accessToken");
		log.info("AccessToken({}) ======> {}", accessToken.length(), accessToken);
		if(accessToken.length() < 32) {
			return new RpcResult(new Exception(accessToken.concat("没有访问权限")));
		}
		return invoker.invoke(invocation);
	}

}
