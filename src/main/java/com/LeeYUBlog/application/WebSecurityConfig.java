package com.LeeYUBlog.application;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http)throws Exception{
		http
			.authorizeRequests()
				.antMatchers("/assets/**","/common/**","/login","/home","/","/index.html").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.permitAll();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		/*auth
			.inMemoryAuthentication()
				.withUser("user").password("password").roles("USER");*/
		//JDBC Authentication
		@SuppressWarnings({ "deprecation", "unused" })
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth
			.jdbcAuthentication()
				.dataSource(dataSource)
				//.withDefaultSchema()
				//.withUser(users.username("user").password("password").roles("USER"))
				//.withUser(users.username("admin").password("password").roles("USER","ADMIN"));
				;
		
	}
}
