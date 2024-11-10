package com.springboot.school.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception{
		httpSecurity
		.csrf(csrf->csrf.disable())
		.authorizeHttpRequests(
				request -> request.requestMatchers("/dashboard").authenticated()
				.requestMatchers("/","/home").permitAll()
				.requestMatchers("/contact").permitAll()
				.requestMatchers("/courses").permitAll()
				.requestMatchers("/saveMsg").permitAll()
				.requestMatchers("/about").permitAll()
				.requestMatchers("/holidays/**").permitAll()
				.requestMatchers("/assets/**").permitAll()
				)
		.formLogin(loginConfigurer -> loginConfigurer.loginPage("/login")
                .defaultSuccessUrl("/dashboard").failureUrl("/login?error=true").permitAll())
        .logout(logoutConfigurer -> logoutConfigurer.logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true).permitAll())
				.httpBasic(Customizer.withDefaults());
		return httpSecurity.build();
	}
	
	@Bean
	public UserDetailsService users() {
		UserDetails user = User.builder()
			.username("user")
			.password("12345")
			.roles("USER")
			.build();
		UserDetails admin = User.builder()
			.username("admin")
			.password("54321")
			.roles("USER", "ADMIN")
			.build();
		return new InMemoryUserDetailsManager(user, admin);
	}
}
