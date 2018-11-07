package org.dante.springboot.dubbo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;

import com.alibaba.dubbo.common.utils.NetUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DubboAPITests {

	@Test
	public void testRegister() throws UnknownHostException {
		String localHost = NetUtils.getLocalHost();
		log.info("LocalHost => {}", localHost);
		InetAddress hostAddr = InetAddress.getLocalHost();
		log.info("HostAddress => {}", hostAddr.toString());
	}

}
