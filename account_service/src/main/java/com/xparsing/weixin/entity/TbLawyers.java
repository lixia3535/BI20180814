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
@TableName("tb_lawyers")
public class TbLawyers extends Model<TbLawyers> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID")
    private String id;
    /**
     * 律师姓名
     */
    @TableField("NAME")
    private String name;
    /**
     * 律师类型
     */
    @TableField("LAWYERTYPE")
    private String lawyertype;
    /**
     * 律师事务所
     */
    @TableField("LAWOFFICE")
    private String lawoffice;
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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLawyertype() {
        return lawyertype;
    }

    public void setLawyertype(String lawyertype) {
        this.lawyertype = lawyertype;
    }

    public String getLawoffice() {
        return lawoffice;
    }

    public void setLawoffice(String lawoffice) {
        this.lawoffice = lawoffice;
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TbLawyers{" +
        ", id=" + id +
        ", name=" + name +
        ", lawyertype=" + lawyertype +
        ", lawoffice=" + lawoffice +
        ", state=" + state +
        ", weightcoef=" + weightcoef +
        "}";
    }
}
