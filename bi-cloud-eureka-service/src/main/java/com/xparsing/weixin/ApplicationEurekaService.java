package com.xparsing.weixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by user on 2018/8/14.
 */
@SpringBootApplication
@EnableEurekaServer
public class ApplicationEurekaService {
    public static void main(String args[]){
        SpringApplication.run(ApplicationEurekaService.class,args);
    }
}
