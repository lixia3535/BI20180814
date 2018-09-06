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
@Document(indexName = "elasticsearch",type = "tbContentLawyer")
public class TbContentLawyer{

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;
    /**
     * 案件主键
     */
    private String contentId;
    /**
     * 律师主键
     */
    private String lawyerId;


}
