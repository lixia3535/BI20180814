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
@TableName("tb_judge")
public class TbJudge extends Model<TbJudge> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID")
    private String id;
    /**
     * 法官名字
     */
    @TableField("JUDGENAME")
    private String judgename;
    /**
     * 法院
     */
    @TableField("COURT")
    private String court;
    /**
     * 状态1有效0无效
     */
    @TableField("STATE")
    private String state;
    /**
     * 权重
     */
    @TableField("WEIGHTCOEF")
    private Integer weightcoef;
    /**
     * 法官类型
     */
    @TableField("JUDGETYPE")
    private String judgetype;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJudgename() {
        return judgename;
    }

    public void setJudgename(String judgename) {
        this.judgename = judgename;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getWeightcoef() {
        return weightcoef;
    }

    public void setWeightcoef(Integer weightcoef) {
        this.weightcoef = weightcoef;
    }

    public String getJudgetype() {
        return judgetype;
    }

    public void setJudgetype(String judgetype) {
        this.judgetype = judgetype;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TbJudge{" +
        ", id=" + id +
        ", judgename=" + judgename +
        ", court=" + court +
        ", state=" + state +
        ", weightcoef=" + weightcoef +
        ", judgetype=" + judgetype +
        "}";
    }
}
