package com.ecommerce.login;

import java.io.IOException;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


	@Component("delegatedAuthenticationEntryPoint")
	public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

	    @Autowired
	    @Qualifier("handlerExceptionResolver")
	    private HandlerExceptionResolver resolver;


	    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) 
	      throws IOException, ServletException {
	        resolver.resolveException(request, response, null, authException);
	    }

		@Override
		public void commence(HttpServletRequest request, HttpServletResponse response,
				org.springframework.security.core.AuthenticationException authException)
				throws IOException, ServletException {
			// TODO Auto-generated method stub
			System.out.println("Hello login error");
			
		}
	}