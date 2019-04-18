package com.mjh.springboot01;

import org.springframework.beans.factory.Aware;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

import java.util.Map;

@SpringBootApplication
public class Springboot01Application extends SpringBootServletInitializer implements WebApplicationInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(Springboot01Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Springboot01Application.class, args);
	}
}
