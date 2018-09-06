package com.xparsing.weixin.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lx
 * @since 2018-09-06
 */
@TableName("tb_content_judge")
public class TbContentJudge extends Model<TbContentJudge> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID")
    private String id;
    /**
     * 法官主键
     */
    @TableField("JUDGE_ID")
    private String judgeId;
    /**
     * 案件主键
     */
    @TableField("CONTENT_ID")
    private String contentId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJudgeId() {
        return judgeId;
    }

    public void setJudgeId(String judgeId) {
        this.judgeId = judgeId;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TbContentJudge{" +
        ", id=" + id +
        ", judgeId=" + judgeId +
        ", contentId=" + contentId +
        "}";
    }
}
