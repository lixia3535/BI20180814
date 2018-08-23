package com.xparsing.weixin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by user on 2018/8/14.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigurationProperties
@MapperScan("com.xparsing.weixin.dao")
public class ApplicationContractClient {
    public static void main(String args[]){
        SpringApplication.run(ApplicationContractClient.class,args);
    }
}
