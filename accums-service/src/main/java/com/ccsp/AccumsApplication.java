package com.ccsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import com.ccsp.common.aspect.LoggingAspect;

/**
 * @author nnarayanaperumaln
 *
 */
@EnableAspectJAutoProxy
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration.class})
public class AccumsApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(AccumsApplication.class, args);
	}
	
	@Bean
	public LoggingAspect getAspect() {
		return new LoggingAspect();
	}
}