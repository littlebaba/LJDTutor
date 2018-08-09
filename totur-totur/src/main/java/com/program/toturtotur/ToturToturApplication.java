package com.program.toturtotur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@SpringBootApplication
public class ToturToturApplication
        extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ToturToturApplication.class);
    }

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
