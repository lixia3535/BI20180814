package com.xparsing.weixin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by user on 2018/8/14.
 */
@SpringBootApplication
//@EnableEurekaClient
@EnableConfigurationProperties
@MapperScan("com.xparsing.weixin.dao")
public class ApplicationContractClient extends  SpringBootServletInitializer{
    /**
     * 打成war包需要加这一段 和继承SpringBootServletInitializer类
     * @param
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder application) {
        return application.sources(ApplicationContractClient.class);
    }
    public static void main(String args[]){
        SpringApplication.run(ApplicationContractClient.class,args);
    }
}
