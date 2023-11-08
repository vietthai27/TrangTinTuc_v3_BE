package com.thai27.trangtintuc_v3_be.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

import com.thai27.trangtintuc_v3_be.JWT.JwtAuthenProvider;
import com.thai27.trangtintuc_v3_be.JWT.JwtTokenFilter;

@SuppressWarnings("deprecation")
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity

public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	JwtTokenFilter tokenFilter;

	@Autowired
	JwtAuthenProvider authentication;

	@Bean
	public AuthenticationManager getauthManager() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authentication);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests()
				.antMatchers("/test-api/user-page/**").hasAnyAuthority("USER", "ADMIN")
				.antMatchers("/test-api/admin-page/**").hasAuthority("ADMIN")
				.antMatchers("/login").permitAll()
				.antMatchers("/resetPassRequest").permitAll()
				.antMatchers("/resetPassValidate").permitAll()
				.antMatchers("/baibao/pass/**").permitAll()
				.antMatchers("/danhmuc/**").permitAll()
				.antMatchers("/test-api/**").permitAll()
				.antMatchers("/signupRequest").permitAll()
				.antMatchers("/signupValidate").permitAll()
				.antMatchers("/test-api/home-page").permitAll()
				.anyRequest().authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);
	}

}
