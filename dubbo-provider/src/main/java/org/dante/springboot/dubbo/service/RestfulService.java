package org.dante.springboot.dubbo.service;

import java.util.List;

import org.dante.springboot.dubbo.api.service.IRestfulService;
import org.dante.springboot.dubbo.api.vo.UserVO;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.common.collect.Lists;

@Service(retries = 0, timeout = 3000, loadbalance = "roundrobin")
public class RestfulService implements IRestfulService {
	
	private static List<UserVO> users = Lists.newArrayList();

	static {
		users.add(new UserVO("dante1", "111qqq"));
		users.add(new UserVO("dante2", "222aaa"));
		users.add(new UserVO("dante3", "333zzz"));
		users.add(new UserVO("dante4", "444xxx"));
	}
	
	@Override
	public void register(UserVO usrVO) {
		users.add(usrVO);
	}

	@Override
	public List<UserVO> findUsers() {
		return users;
	}

}
