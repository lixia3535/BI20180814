package com.xparsing.weixin.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lx
 * @since 2018-08-23
 */
public class Content extends Model<Content> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 标题
     */
    private String name;
    /**
     * 发布日期
     */
    @TableField("release_date")
    private String releaseDate;
    /**
     * 具体内容
     */
    @TableField("content_definite")
    private String contentDefinite;
    /**
     * 公告
     */
    private String announcement;
    /**
     * 案件类型
     */
    @TableField("law_type")
    private String lawType;
    /**
     * 审理程序
     */
    @TableField("hearing_procedure")
    private String hearingProcedure;
    /**
     * 裁判日期
     */
    @TableField("law_date")
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
    @TableField("legal_representative")
    private String legalRepresentative;
    /**
     * 审理法院
     */
    @TableField("court_id")
    private String courtId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getContentDefinite() {
        return contentDefinite;
    }

    public void setContentDefinite(String contentDefinite) {
        this.contentDefinite = contentDefinite;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public String getLawType() {
        return lawType;
    }

    public void setLawType(String lawType) {
        this.lawType = lawType;
    }

    public String getHearingProcedure() {
        return hearingProcedure;
    }

    public void setHearingProcedure(String hearingProcedure) {
        this.hearingProcedure = hearingProcedure;
    }

    public String getLawDate() {
        return lawDate;
    }

    public void setLawDate(String lawDate) {
        this.lawDate = lawDate;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getBasis() {
        return basis;
    }

    public void setBasis(String basis) {
        this.basis = basis;
    }

    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {
        this.judge = judge;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getPlaintiff() {
        return plaintiff;
    }

    public void setPlaintiff(String plaintiff) {
        this.plaintiff = plaintiff;
    }

    public String getDefendant() {
        return defendant;
    }

    public void setDefendant(String defendant) {
        this.defendant = defendant;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getCourtId() {
        return courtId;
    }

    public void setCourtId(String courtId) {
        this.courtId = courtId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Content{" +
        ", id=" + id +
        ", name=" + name +
        ", releaseDate=" + releaseDate +
        ", contentDefinite=" + contentDefinite +
        ", announcement=" + announcement +
        ", lawType=" + lawType +
        ", hearingProcedure=" + hearingProcedure +
        ", lawDate=" + lawDate +
        ", people=" + people +
        ", reason=" + reason +
        ", basis=" + basis +
        ", judge=" + judge +
        ", agent=" + agent +
        ", plaintiff=" + plaintiff +
        ", defendant=" + defendant +
        ", legalRepresentative=" + legalRepresentative +
        ", courtId=" + courtId +
        "}";
    }
}
