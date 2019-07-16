package com.codeassist.CodeAssist;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class CodeAssistApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeAssistApplication.class, args);
	}
}
