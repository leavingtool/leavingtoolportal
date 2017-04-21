package com.dynagility.leavingtoolportal.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.dynagility.leavingtoolportal.security.UserDetailServiceCustom;

@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {
	

	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;

	@Autowired
	private AuthenticationFailureHandler authenticationFailureHandler;

	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	
	@Autowired
    private UserDetailsService  userDetailsService;
	
	
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//				.withUser("admin").password("admin").roles("ADMIN", "USER")
//				.and().withUser("user").password("user").roles("USER");
//	}
	
	 @Override
	 public void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService);
	  }
	
		@Override
	    protected void configure(HttpSecurity http) throws Exception { 
			
	        http.csrf().disable().authorizeRequests()
	        .antMatchers("/api/**").hasAuthority("USER")
			.anyRequest().fullyAuthenticated()
			.and()
			.httpBasic();
			//.exceptionHandling()
			//.authenticationEntryPoint(authenticationEntryPoint);
	       // .antMatchers(HttpMethod.GET, "/api/**").access("hasRole('USER')")

	        FormLoginConfigurer<HttpSecurity> formLogin = http.formLogin();
	        formLogin.successHandler(authenticationSuccessHandler);
	        formLogin.failureHandler(authenticationFailureHandler);
	    }
}
