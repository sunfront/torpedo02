package com.gradle.torpedo02.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private final long MAX_AGE_SECS = 3600;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            //.allowedOrigins("*"
            		//"http://localhost:8081"
            		//, "chrome-extension://olmlmojdkjjmkdsmamjiafjefsabpgkb", "chrome-extension://bmiikilfohkmhgnphfddcocjkohaeomc", "chrome-extension://kgpkhhnkisfsbijhimdhfefainbkigbf"
            //		)
        	.allowedOriginPatterns("*")
        // GET, POST, PATCH, DELETE, OPTIONS 메서드 허용
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(MAX_AGE_SECS);
    }
}
