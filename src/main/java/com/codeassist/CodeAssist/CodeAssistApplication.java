package com.codeassist.CodeAssist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CodeAssistApplication extends SpringBootServletInitializer{
	/*
	 * Overriding configure method so the application could be deployed as war package
	 */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CodeAssistApplication.class);
    }
	public static void main(String[] args) {
		SpringApplication.run(CodeAssistApplication.class, args);
	}
}
