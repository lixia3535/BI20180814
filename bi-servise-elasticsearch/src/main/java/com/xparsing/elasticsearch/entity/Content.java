package com.xparsing.elasticsearch.entity;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Document(indexName = "elasticsearch",type = "content")
public class Content{

    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * 标题
     */
    private String name;
    /**
     * 发布日期
     */
    private String releaseDate;
    /**
     * 具体内容
     */
    private String contentDefinite;
    /**
     * 公告
     */
    private String announcement;
    /**
     * 案件类型
     */
    private String lawType;
    /**
     * 审理程序
     */
    private String hearingProcedure;
    /**
     * 裁判日期
     */
    private String lawDate;
    /**
     * 当事人
     */
    private String people;
    /**
     * 案由
     */
    private String reason;
    /**
     * 法律依据
     */
    private String basis;
    /**
     * 法官
     */
    private String judge;
    /**
     * 律师（委托代理人）
     */
    private String agent;
    /**
     * 原告
     */
    private String plaintiff;
    /**
     * 被告
     */
    private String defendant;
    /**
     * 发定代表人
     */
    private String legalRepresentative;
    /**
     * 审理法院
     */
    private String courtId;
    private String cityId;


}
