package com.smartbank.notificationservice.config;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ProjectSecurityConfig {

	 private static final String[] PUBLIC_URLS = {
	            "/v1/customer/register",
	            "/actuator/**"
	    };
	 
	 
	 /**
	 * <p><b>SessionManagement</b> : Do not use Session Managment
	 * <p><b>CORS</b> : Check configuration in {@link corsConfigurationSource} method
	 * <p><b>CSRF</b> : Do not use Session Managment
	 * <p><b>SessionManagement</b> : Do not use Session Managment
	 * <p><b>SessionManagement</b> : Do not use Session Managment
	 * <p><b>SessionManagement</b> : Do not use Session Managment
	 * @param http
	 * @return
	 * @throws Exception
	 */
	@Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		
		http
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.cors(cors -> cors.configurationSource(corsConfigurationSource()))
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(
					 request -> request.anyRequest().permitAll()
					)
			.httpBasic(Customizer.withDefaults())
			.formLogin(formlogin -> formlogin.disable());
	
		
     return http.build();
    }
	
	/*
	 * @Bean public PasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */
	/**
	 * These configurations once fetched by browser or client valid till 3600 Seconds i.e. 1 Hour
	 * @return
	 */
	@Bean
    public CorsConfigurationSource corsConfigurationSource() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("http://localhost:8080","http://localhost:8084","http://localhost:8086","http://localhost:8088")); 
        config.setAllowedMethods(List.of("GET", "POST", "PUT","OPTIONS"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowedHeaders(Collections.singletonList("*"));
        config.setExposedHeaders(Collections.singletonList("*"));
        config.setMaxAge(3600L);
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
