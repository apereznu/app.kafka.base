package com.robotoit.app.kafka.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class HelloControllerTest {
	

	private HelloController hello;

	@BeforeEach
	void setUp() throws Exception {
		hello= new HelloController();
	}

	@Test
	void hellotTest() {
		String response =hello.sayHello("alberto");
		assertEquals("hello alberto", response);
	}
}
