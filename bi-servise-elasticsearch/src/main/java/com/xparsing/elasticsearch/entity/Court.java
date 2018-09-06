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
@Data
@Document(indexName = "elasticsearch",type = "court")
public class Court {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String court;
    private Integer courtId;
    private Integer cityId;
}
