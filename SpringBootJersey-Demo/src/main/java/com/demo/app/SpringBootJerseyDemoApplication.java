package com.demo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan({"com.demo.endpoint","com.manju"})
public class SpringBootJerseyDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJerseyDemoApplication.class, args);
	}
}
