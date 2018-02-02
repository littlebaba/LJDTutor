package com.program.toturtotur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@SpringBootApplication
public class ToturToturApplication {

	public static void main(String[] args) throws IOException {
		//更改properties配置文件名称，避免依赖冲突
		Properties properties = new Properties();
		InputStream in = ToturToturApplication.class.getClassLoader().getResourceAsStream("totur.properties");
		properties.load(in);
		SpringApplication app = new SpringApplication(ToturToturApplication.class);
		app.setDefaultProperties(properties);
		app.run(args);
//		SpringApplication.run(ToturToturApplication.class, args);
	}
}
