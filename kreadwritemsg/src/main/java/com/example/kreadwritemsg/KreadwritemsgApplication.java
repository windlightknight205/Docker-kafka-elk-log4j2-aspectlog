package com.example.kreadwritemsg;

import com.example.kreadwritemsg.service.LogService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KreadwritemsgApplication {
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(KreadwritemsgApplication.class, args);
//		LogService helloWorld = new LogService();
//		LogService.createLogs();
	}
}
