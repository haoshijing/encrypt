package com.hulian.encrypt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@EnableAutoConfiguration
@ImportResource({"classpath:application-context.xml"})
public class ApplicationStartLauncher {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStartLauncher.class, args);
    }
}
