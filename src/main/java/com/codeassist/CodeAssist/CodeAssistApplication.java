package com.codeassist.CodeAssist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/** CodeAssist application is intended as a tool for Accenture bootcampers to share their issues through local server.
 * One of main issues we face when taking part in Accenture bootcamp was the fact that you are able to communicate only
 * with people sitting near you instead of whole group. By creating this application we tried to solve this communication 
 * problem on larger scale.
 * This application allows users to share their current issues or problems that they are facing as well as help others by leaving a reply.
 *
 * @author Elina Rostoka, Emils Verinsh, Janis Vigulis, Raivo Lapinsh
 */
@SpringBootApplication
public class CodeAssistApplication extends SpringBootServletInitializer{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CodeAssistApplication.class);
    }
	public static void main(String[] args) {
		SpringApplication.run(CodeAssistApplication.class, args);
	}
}
