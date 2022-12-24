package com.robotoit.app.kafka.controller;

import java.sql.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	KafkaTemplate<Integer, String> kafkaTemplate;
	
	@GetMapping("/v1/hello")
	public String sayHello(@RequestParam String name){
		return "hello ".concat(name);
	}
	
	@PostMapping("/v1/send")
	public String sendMessage(@RequestBody String message) throws InterruptedException, ExecutionException, TimeoutException{
		kafkaTemplate.send("test" ,1000,  message).get(100, TimeUnit.MILLISECONDS);
		return "sent message";
	}
}
