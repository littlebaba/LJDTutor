package com.program.tutorcommon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TutorCommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorCommonApplication.class, args);
	}
}
