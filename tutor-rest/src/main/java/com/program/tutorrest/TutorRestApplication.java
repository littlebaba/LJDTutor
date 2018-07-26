package com.program.tutorrest;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Li on 2018/3/2.
 */
@SpringBootApplication
@EnableCaching
public class TutorRestApplication {
    public static void main(String[] args) throws IOException{
        //更改properties配置文件名称，避免依赖冲突
        Properties properties = new Properties();
        InputStream in = TutorRestApplication.class.getClassLoader().getResourceAsStream("rest.properties");
        properties.load(in);
        SpringApplication app = new SpringApplication(TutorRestApplication.class);
        app.setDefaultProperties(properties);
        app.run(args);
    }
}


















