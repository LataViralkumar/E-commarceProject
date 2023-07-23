package com.ecommerce.login;


import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class LoginConfig {
	

	@Bean
	UserDetailsService userDetailsService() {
		
		return new CustomUserDetailsService();
	}
	
	

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    	http
    	.csrf().disable().authorizeHttpRequests().
//    	requestMatchers("/userpage/productForCart/").permitAll().
 
    	requestMatchers(HttpMethod.POST, "/userpage/").
    	authenticated().
    	anyRequest().
    	permitAll().
    	and().
    	formLogin().loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/userpage/" ,true)
    	.and().logout().permitAll();
    	
        return http.build();
    }
    
    @Bean
     BCryptPasswordEncoder passwordEncoder() {
   	
    	return new BCryptPasswordEncoder();
    }
    
    
    @Bean
     AuthenticationProvider authenticationProvider() {
    	
    	DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    	daoAuthenticationProvider.setUserDetailsService(userDetailsService());
    	daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
    	
		return daoAuthenticationProvider;
    	
    }
    
}
