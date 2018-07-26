package com.program.tutorcommon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jersey.JerseyAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author Li
 */
@SpringBootApplication
@EnableCaching

public class TutorCommonApplication{

	public static void main(String[] args) {
		SpringApplication.run(TutorCommonApplication.class, args);
	}
}
