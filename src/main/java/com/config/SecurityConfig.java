package com.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

import com.domain.UserDetialsServiceImpl;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	final static String REMEMBER_ME = "james_page";
	
	@Autowired
	UserDetialsServiceImpl userDetailsService;
	
	@Autowired
	DataSource dataSource;
	
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
		http.rememberMe().key(REMEMBER_ME).rememberMeServices(persistentTokenBasedRememberMeServices());
		http.logout().logoutSuccessUrl("/");
	}
	
	@Bean
	public TokenBasedRememberMeServices tokenBasedRememberMeServices(){
		TokenBasedRememberMeServices tokenBasedRememberMeServices = new TokenBasedRememberMeServices(REMEMBER_ME, userDetailsService);
		return tokenBasedRememberMeServices;
	}
	
	@Bean
	public PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices(){
		PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices = new PersistentTokenBasedRememberMeServices(REMEMBER_ME, userDetailsService, jdbcTokenRepositoryImpl());
		return persistentTokenBasedRememberMeServices;
	}
	
	@Bean
	public JdbcTokenRepositoryImpl jdbcTokenRepositoryImpl(){
		JdbcTokenRepositoryImpl jdbcTokenRepositoryImpl = new JdbcTokenRepositoryImpl();
		jdbcTokenRepositoryImpl.setCreateTableOnStartup(false);
		jdbcTokenRepositoryImpl.setDataSource(dataSource);
		return jdbcTokenRepositoryImpl;
	}
}
