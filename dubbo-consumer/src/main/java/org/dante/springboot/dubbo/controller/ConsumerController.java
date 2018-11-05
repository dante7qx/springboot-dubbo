package org.dante.springboot.dubbo.controller;

import org.dante.springboot.dubbo.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
	
	@Autowired
	private ConsumerService consumerService;

	@GetMapping("/{msg}")
	public String sayHello(@PathVariable String msg) {
		return consumerService.sayHello(msg);
	}
	
}
