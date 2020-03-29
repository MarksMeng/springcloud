package com.pangzi.vue_element_admin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class WebResourceConfig extends WebMvcConfigurerAdapter {

    @Value("${img.upload.folder}")
    private String resourcesLocation;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/img/**").addResourceLocations("file:"+resourcesLocation+"/");
        super.addResourceHandlers(registry);
    }
}
