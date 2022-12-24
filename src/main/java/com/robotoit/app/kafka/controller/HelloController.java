package com.robotoit.app.kafka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/v1/hello")
	public String sayHello(@RequestParam String name){
		return "hello ".concat(name);
	}
	
}
