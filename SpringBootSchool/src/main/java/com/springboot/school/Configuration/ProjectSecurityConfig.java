package com.springboot.school.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.authorizeHttpRequests(
				request -> request.requestMatchers("/").permitAll()
				.requestMatchers("/home").permitAll()
				.requestMatchers("/contact").permitAll()
				.requestMatchers("/courses").permitAll()
				.requestMatchers("/saveMsg").permitAll()
				.requestMatchers("/about").permitAll()
				.requestMatchers("/holidays/**").permitAll()
				.requestMatchers("/assets/**").permitAll()
				)
				.formLogin(Customizer.withDefaults())
				.httpBasic(Customizer.withDefaults());
		return httpSecurity.build();
	}
}
