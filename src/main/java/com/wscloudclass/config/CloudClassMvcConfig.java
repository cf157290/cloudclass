package com.wscloudclass.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CloudClassMvcConfig {
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            public void addViewControllers(ViewControllerRegistry registry){
                registry.addViewController("/").setViewName("/login.html");
                registry.addViewController("/index").setViewName("/index.html");
                registry.addViewController("/join.html").setViewName("/join.html");
                registry.addViewController("/create.html").setViewName("/create.html");
                registry.addViewController("/classnav.html").setViewName("/classnav.html");
                registry.addViewController("/activity.html").setViewName("/activity.html");
                registry.addViewController("/member.html").setViewName("/member.html");
                registry.addViewController("/resources.html").setViewName("/resources.html");
                registry.addViewController("/details.html").setViewName("/details.html");
            }
        };
    }
}
