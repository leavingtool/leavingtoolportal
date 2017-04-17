package com.dynagility.leavingtoolportal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {

//	 http.authorizeRequests()
//     .antMatchers("/", "/public/**").permitAll()
//     .antMatchers("/users/**").hasAuthority("ADMIN")
//     .anyRequest().fullyAuthenticated()
//     .and()
//     .formLogin()
//     .loginPage("/login")
//     .failureUrl("/login?error")
//     .usernameParameter("email")
//     .permitAll()
//     .and()
//     .logout()
//     .logoutUrl("/logout")
//     .deleteCookies("remember-me")
//     .logoutSuccessUrl("/")
//     .permitAll()
//     .and()
//     .rememberMe();
//    }
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(new BCryptPasswordEncoder());
//    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/api/**").anonymous()
	     		.antMatchers("/users/**").hasAuthority("ADMIN")
				.anyRequest().fullyAuthenticated()
//				.and().formLogin().loginPage("/login").failureUrl("/login?error").permitAll()
//				.and().logout().permitAll()
				;
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("admin").password("admin").roles("ADMIN", "USER")
				.and().withUser("user").password("user").roles("USER");
	}
}
