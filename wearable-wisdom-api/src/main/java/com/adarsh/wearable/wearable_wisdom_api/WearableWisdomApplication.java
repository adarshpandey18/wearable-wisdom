package com.adarsh.wearable.wearable_wisdom_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WearableWisdomApplication {
	public static void main(String[] args) {
		SpringApplication.run(WearableWisdomApplication.class, args);
	}
}
