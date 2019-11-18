package com.pangzi.springcloud.configserver;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@Slf4j
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigServerApplication
{
    public static void main( String[] args ){
        SpringApplication.run(ConfigServerApplication.class);
        log.info("ConfigServerApplication启动");
    }
}
