package com.generation.redeSocial.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsImpService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/usuario/logar").permitAll()
		.antMatchers("/usuario/cadastrar").permitAll()
		.antMatchers(HttpMethod.GET, "/produto").permitAll()
		.antMatchers("/produto/porId/{id}").permitAll()
		.antMatchers(HttpMethod.GET, "/categoria").permitAll()
		.anyRequest().authenticated()
		.and().httpBasic()
		.and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().cors()
		.and().csrf().disable();
	}

	/*
	 * http.csrf().disable().authorizeRequests() .antMatchers(HttpMethod.GET,
	 * "/").permitAll() .anyRequest().authenticated() .and().formLogin().permitAll()
	 * .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	 */	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	protected void Configure(AuthenticationManagerBuilder auth ) throws Exception{
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder());
	}
}
