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
@Document(indexName = "elasticsearch",type = "tbJudge")
public class TbJudge {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;
    /**
     * 法官名字
     */
    private String judgename;
    /**
     * 法院
     */
    private String court;
    /**
     * 状态1有效0无效
     */
    private String state;
    /**
     * 权重
     */
    private Integer weightcoef;
    /**
     * 法官类型
     */

}
