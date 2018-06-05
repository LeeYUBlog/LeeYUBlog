package com.LeeYUBlog.application;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	//@Autowired
	//private DataSource dataSource;
	
	@Inject
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http)throws Exception{
		http
			.authorizeRequests()
				.antMatchers("/assets/**","/common/**","/login","/home","/","/index.html","/indexFiles/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				/*登陆成功后跳转到后台页面*/
				.defaultSuccessUrl("/admin")
				.failureUrl("/login?error")
				.permitAll()
				.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/home")
				.invalidateHttpSession(true)
				.permitAll();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		/*auth
			.inMemoryAuthentication()
				.withUser("user").password("password").roles("USER");*/
		//JDBC Authentication
		/*@SuppressWarnings({ "deprecation", "unused" })
		UserBuilder users = User.withDefaultPasswordEncoder();*/
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(11);
		auth
			.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder)
			//.jdbcAuthentication()
				//.dataSource(dataSource)
				//.withDefaultSchema()
				//.withUser(users.username("user").password("password").roles("USER"))
				//.withUser(users.username("admin").password("password").roles("USER","ADMIN"));
				;
		
	}
}
