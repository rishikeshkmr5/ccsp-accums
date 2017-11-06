package com.ccsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import com.ccsp.com.rules.webservice.serviceImpl.RulesFactoryImpl;
import com.ccsp.common.aspect.LoggingAspect;
import com.ccsp.common.report.DownloadReport;
import com.ccsp.common.report.UploadReport;
import com.ccsp.common.rules.webservice.service.IRulesFactory;

/**
 * @author nnarayanaperumaln This class should be on the root package as it is
 *         used for configurations.
 *
 */
@EnableAspectJAutoProxy
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan
@EnableAutoConfiguration(exclude = { org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
		org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration.class })
public class AccumsApplication extends SpringBootServletInitializer {

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

	@Bean
	public DownloadReport getDownloadReport() {
		return new DownloadReport();
	}

	@Bean
	public UploadReport getUploadReport() {
		return new UploadReport();
	}

	@Bean
	public IRulesFactory getRulesFactoryImpl() {
		return new RulesFactoryImpl();
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AccumsApplication.class);
	}
}