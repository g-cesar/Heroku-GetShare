package com.project.getshare.authentication;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.getshare.model.Credentials;

@Configuration
@EnableWebSecurity
public class AuthConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource datasource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/", "/index", "/login", "/user/signup", "/css/**", "/js/**", "/admin/signup").permitAll()
				.antMatchers(HttpMethod.POST, "/login", "/", "/index", "/admin/signup/addAdmin").permitAll()
				.antMatchers(HttpMethod.GET, "/admin").hasAnyAuthority(Credentials.ADMIN_ROLE)
				.anyRequest().authenticated()
				.and().formLogin()
				.defaultSuccessUrl("/store")
				.and().logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/");
				
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
				.dataSource(this.datasource)
				.authoritiesByUsernameQuery("SELECT email AS username, role FROM credentials WHERE email=?")
				.usersByUsernameQuery("SELECT email AS username, password, 1 AS enabled FROM credentials WHERE email=?");
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
