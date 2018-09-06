package com.xparsing.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * Created by user on 2018/8/28.
 */
@SpringBootApplication
//@EnableElasticsearchRepositories
public class ApplictionElasticSearch {
    public static void main(String args[]){
        SpringApplication.run(ApplictionElasticSearch.class,args);
    }
}
