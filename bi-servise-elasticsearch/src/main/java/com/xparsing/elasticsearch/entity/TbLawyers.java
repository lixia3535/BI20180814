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
@Document(indexName = "elasticsearch",type = "tbLawyers")
public class TbLawyers {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;
    /**
     * 律师姓名
     */
    private String name;
    /**
     * 律师类型
     */
    private String lawyertype;
    /**
     * 律师事务所
     */
    private String lawoffice;
    /**
     * 状态1有效0无效
     */
    private String state;
    /**
     * 权重
     */
    private Integer weightcoef;

}
