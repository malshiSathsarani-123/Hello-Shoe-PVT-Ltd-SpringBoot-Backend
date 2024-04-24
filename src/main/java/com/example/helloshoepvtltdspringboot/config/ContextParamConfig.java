package com.example.helloshoepvtltdspringboot.config;

import jakarta.servlet.ServletContext;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ContextParamConfig implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        servletContext.setInitParameter("origin", "http://localhost:63342");
    }
}
