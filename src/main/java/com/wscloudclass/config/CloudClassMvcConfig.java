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
                registry.addViewController("/grade.html").setViewName("/grade.html");
                registry.addViewController("/message.html").setViewName("/message.html");
                registry.addViewController("/ranking.html").setViewName("/ranking.html");
                registry.addViewController("/answer.html").setViewName("/answer.html");
                registry.addViewController("/desanswer.html").setViewName("/desanswer.html");
                registry.addViewController("/userinfo.html").setViewName("/userinfo.html");
                registry.addViewController("/modinfo.html").setViewName("/modinfo.html");
                registry.addViewController("/result.html").setViewName("/result.html");
                registry.addViewController("/initse.html").setViewName("/initse.html");
                registry.addViewController("/collection.html").setViewName("/collection.html");
                registry.addViewController("/score.html").setViewName("/score.html");
            }
        };
    }
}
