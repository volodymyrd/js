package com.gmail.volodymyrdotsenko.routing.frontend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Created by Volodymyr Dotsenko on 12/12/16.
 */
@Configuration
public class RestConfiguration {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        //config.setAllowedOrigins(Stream.of("http://localhost:8082").collect(Collectors.toList()));
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        //config.addAllowedMethod("PUT");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
