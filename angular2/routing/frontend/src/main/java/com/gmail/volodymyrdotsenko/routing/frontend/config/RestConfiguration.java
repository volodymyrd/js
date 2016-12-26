package com.gmail.volodymyrdotsenko.routing.frontend.config;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Volodymyr Dotsenko on 12/12/16.
 */
//@Configuration
public class RestConfiguration {
    //@Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Stream.of("http://localhost:4200", "http://localhost:8081").collect(Collectors.toList()));
        //config.addAllowedOrigin("http://localhost:8081");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        //config.addAllowedMethod("PUT");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
