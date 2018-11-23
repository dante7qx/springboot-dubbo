package org.dante.springboot.dubbo.api.service;

import java.util.List;

import org.dante.springboot.dubbo.api.vo.UserVO;

public interface IRestfulService {
	public void register(UserVO usrVO);
	
	public List<UserVO> findUsers();
	
}
