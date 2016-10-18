package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.domain.UserDetialsServiceImpl;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	final static String REMEMBER_ME = "james_page";
	
	@Autowired
	UserDetialsServiceImpl userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/users/**").hasRole("USER")
		                        .antMatchers("/admin/**").hasRole("ADMIN")
		                        .antMatchers("/**").permitAll();
		
		http.formLogin().loginPage("/login").permitAll();
		http.rememberMe().key(REMEMBER_ME);
		http.logout().logoutSuccessUrl("/");
	}
}
