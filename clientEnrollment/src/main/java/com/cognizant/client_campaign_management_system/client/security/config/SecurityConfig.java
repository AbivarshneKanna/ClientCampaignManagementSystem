package com.cognizant.client_campaign_management_system.client.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@SuppressWarnings("deprecation")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("client").password("password").roles("ADMIN");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/**").hasAnyRole("ADMIN")
        .antMatchers(HttpMethod.POST,"/**").hasAnyRole("ADMIN")
        .antMatchers(HttpMethod.PUT,"/**").hasAnyRole("ADMIN")
		.antMatchers("/client/save")
		.hasRole("ADMIN")
		.antMatchers("/")
		.permitAll().and()
		.httpBasic();
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
