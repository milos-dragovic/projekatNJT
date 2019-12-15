package com.durag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.durag.config.JwtFilter;

@SpringBootApplication
public class DuragBackendApplication {
	
	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());  //registracija json web token filtera u Spring kontejner
		registrationBean.addUrlPatterns("/rest/*");  //URL pattern putanja na kojoj je registrovan filter
		return registrationBean;
	}

	//entry point aplikacije
	public static void main(String[] args) {
		SpringApplication.run(DuragBackendApplication.class, args);
	}

}
