package com.xparsing.weixin.filter;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * 过滤不需要监控的后缀
 * Created by user on 2018/8/1.
 * 配置监控拦截
 * druid监控拦截器
 */
@WebFilter(filterName = "druidWebStatFilter",
        urlPatterns = "/",
        initParams = {@WebInitParam(name = "exclusions",value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")//忽略的资源
        })
public class DruidStatFilter extends WebStatFilter {

}
