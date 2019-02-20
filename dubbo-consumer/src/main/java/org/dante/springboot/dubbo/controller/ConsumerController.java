package org.dante.springboot.dubbo.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.dante.springboot.dubbo.api.vo.UserVO;
import org.dante.springboot.dubbo.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
	
	@Autowired
	private ConsumerService consumerService;

	@GetMapping("/{msg}")
	public String sayHello(@PathVariable String msg) {
		return consumerService.sayHello(msg);
	}
	
	@GetMapping("/delay/{delay}")
	public String delay(@PathVariable int delay) {
		return consumerService.delay(delay);
	}
	
	@GetMapping("/users")
	public List<UserVO> findUsers() {
		return consumerService.findUsers();
	}
	
	@PostMapping("/user")
	public UserVO registerUser(@RequestBody UserVO userVO) {
		consumerService.register(userVO);
		return userVO;
	}
	
	@GetMapping("/upload/{fileName}")
	public String upload(@PathVariable String fileName) throws FileNotFoundException {
		return consumerService.upload(fileName);
	}
}
