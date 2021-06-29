package com.lhu.springbootSecurity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration // to tell we are Doing some configuration here
@EnableWebSecurity  // to tell enable spring web security by mapping this
//@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	/*
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
		csrf().
		disable().
		authorizeRequests().antMatchers("/logoutProcess").permitAll().
		anyRequest().authenticated().
		and().
		httpBasic();		
	}
	
	*/
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authProvider() {
		System.out.println("authProvider Entered");
		DaoAuthenticationProvider daoAuthProvider = new DaoAuthenticationProvider();
		daoAuthProvider.setUserDetailsService(userDetailsService);
	    //daoAuthProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
	    daoAuthProvider.setPasswordEncoder(new BCryptPasswordEncoder());
	    System.out.println("authProvider "+daoAuthProvider.toString());
	    return daoAuthProvider;
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
	/*	
		http.authorizeRequests()
		.antMatchers("/").access("hasRole('USER')")
        .antMatchers("/admin/**").access("hasRole('ADMIN')")
        .and()
        .formLogin()
        .loginProcessingUrl("/login")       // link to submit username-password
        .loginPage("/login")
        .usernameParameter("username")      // username field in login form
        .passwordParameter("password")      // password field in login form
        .defaultSuccessUrl("/")             
        .failureUrl("/login?error")
        .and()
        .logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))            
        .logoutSuccessUrl("/login")
        .invalidateHttpSession(true)        // set invalidation state when logout
        .deleteCookies("JSESSIONID")        
        .and()
        .exceptionHandling()
        .accessDeniedPage("/403");
		*/
		http
		.csrf()
		.disable()
		.authorizeRequests()
		.antMatchers("/").access("hasRole('USER')")
        .antMatchers("/admin/**").access("hasRole('ADMIN')")
		.antMatchers("/login").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.successForwardUrl("/userDetail")
		.permitAll()
		.and()
		.logout().invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logoutProcess"))
		.logoutSuccessUrl("/logout").permitAll();
		
		/*
		http
		.csrf()
		.disable()
		.authorizeRequests().antMatchers("/login").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.and()
		.logout().invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logoutProcess"))
		.logoutSuccessUrl("/logout").permitAll();
		 */
	}
	
	
	
	
	

	/*@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		List<UserDetails> userDetails =  new ArrayList<>();
		userDetails.add(User.withDefaultPasswordEncoder().username("lahiru").password("abc123").roles("USER").build());
		return new InMemoryUserDetailsManager(userDetails);
	}
     */
}
