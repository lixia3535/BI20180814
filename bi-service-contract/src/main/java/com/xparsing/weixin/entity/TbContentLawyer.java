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
 * @since 2018-08-27
 */
@TableName("tb_content_lawyer")
public class TbContentLawyer extends Model<TbContentLawyer> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID")
    private String id;
    /**
     * 案件主键
     */
    @TableField("CONTENT_ID")
    private String contentId;
    /**
     * 律师主键
     */
    @TableField("LAWYER_ID")
    private String lawyerId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getLawyerId() {
        return lawyerId;
    }

    public void setLawyerId(String lawyerId) {
        this.lawyerId = lawyerId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TbContentLawyer{" +
        ", id=" + id +
        ", contentId=" + contentId +
        ", lawyerId=" + lawyerId +
        "}";
    }
}
