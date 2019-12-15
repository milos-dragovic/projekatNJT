package com.durag.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Rest Configuarcija
 * 
 * Spring Bean-a za CORS Filter 
 * 
 * *
 * @author acer e1
 *
 */


@Configuration
public class RestConfig {

	@Bean
    public CorsFilter corsFilter() {

		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(); // instanca Cors-a po requestu
        final CorsConfiguration configuration = new CorsConfiguration(); // CORS Kontejner
        
        //podesavanje Cors kontejnera
        configuration.setAllowCredentials(true); // obicno se traze kredencijali
        configuration.addAllowedOrigin("*"); 
        configuration.addAllowedHeader("*"); 
        configuration.addAllowedMethod("OPTIONS");
        configuration.addAllowedMethod("GET");
        configuration.addAllowedMethod("PUT");
        configuration.addAllowedMethod("POST");
        source.registerCorsConfiguration("/**", configuration); // registracija cors konfiguacije 
        return new CorsFilter(source); //definisan Cors filtera po request-u
    }
	
}
