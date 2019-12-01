package com.pangzi.vue_element_admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import javax.annotation.ManagedBean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@Slf4j
@ManagedBean("com.pangzi.vue_element_admin.mapper")
public class VueElementAdminApplication {
    public static void main(String[] args){
        SpringApplication.run(VueElementAdminApplication.class);
        log.info("VueElementAdminApplication启动");
    }
}
