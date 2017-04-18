package com.dynagility.leavingtoolportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dynagility.leavingtoolportal.model.Account;
import com.dynagility.leavingtoolportal.repository.AccountRepository;
import com.dynagility.leavingtoolportal.security.SecurityUtil;

@SpringBootApplication
@EnableScheduling
@ComponentScan("com")
public class Application {

    @Bean
    SecurityUtil createInstance() {
        return new SecurityUtil();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    CommandLineRunner init(final AccountRepository accountRepository) {
      
      return new CommandLineRunner() {

        @Override
        public void run(String... arg0) throws Exception {
            // TODO Auto-generated method stub
            
        }
        
      };
    }
}

//@Configuration
//class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {
//
//  @Autowired
//  AccountRepository accountRepository;
//
//  @Override
//  public void init(AuthenticationManagerBuilder auth) throws Exception {
//    auth.userDetailsService(userDetailsService());
//  }
//
//  @Bean
//  public HibernateJpaSessionFactoryBean sessionFactory() {
//      return new HibernateJpaSessionFactoryBean();
//  }
//  @Bean
//  UserDetailsService userDetailsService() {
//    return new UserDetailsService() {
//
//      @Override
//      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Account account = accountRepository.findByUsername(username);
//        if(account != null) {
//        return new User(account.getUsername(), account.getPassword(), true, true, true, true,
//                AuthorityUtils.createAuthorityList("USER"));
//        } else {
//          throw new UsernameNotFoundException("could not find the user '"
//                  + username + "'");
//        }
//      }
//      
//    };
//  }
//}
//
//@EnableWebSecurity
//@Configuration
//class WebSecurityConfig extends WebSecurityConfigurerAdapter {
// 
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    http.authorizeRequests().anyRequest().fullyAuthenticated().and().
//    httpBasic().and().
//    csrf().disable();
//  }
//  
//}