package com.xparsing.elasticsearch.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lx
 * @since 2018-08-27
 */
//注解Date会自动加上getter、setter、equals、canEqual、hashCode、toString方法
@Data
@Document(indexName = "elasticsearch",type = "city")
public class City implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String cityName;
    private Integer cityId;


}
