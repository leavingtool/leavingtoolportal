package com.dynagility.leavingtoolportal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	

	@Autowired
	private BasicAuthenticationEntryPoint authenticationEntryPoint;
	
	@Autowired
	private LogoutSuccessHandler logoutSuccessHandler;

	@Autowired
	private AuthenticationFailureHandler authenticationFailureHandler;

	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	
	@Autowired
    private UserDetailsService  userDetailsService;
	
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
			.httpBasic()
	//		.authenticationEntryPoint(authenticationEntryPoint)
			;
	       // .antMatchers(HttpMethod.GET, "/api/**").access("hasRole('USER')")

	        http.formLogin().permitAll()
	      //  .loginProcessingUrl("/login")
//	        .successHandler(authenticationSuccessHandler)
//	        .failureHandler(authenticationFailureHandler)
	        ;
//	        http.logout().permitAll()
        //    .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
//            .logoutSuccessHandler(logoutSuccessHandler)
//            .and()
//            .sessionManagement()
//            .maximumSessions(1);
//	        ;
	   
	    }
}
