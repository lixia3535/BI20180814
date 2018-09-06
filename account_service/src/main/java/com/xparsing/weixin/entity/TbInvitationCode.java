package com.xparsing.weixin.entity;

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
@TableName("tb_invitation_code")
public class TbInvitationCode extends Model<TbInvitationCode> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;
    /**
     * OpenId
     */
    @TableField("open_id")
    private String openId;
    /**
     * 邀请码
     */
    @TableField("invitation_code")
    private String invitationCode;
    /**
     * 1表示有效0无效
     */
    private String state;
    /**
     * 1表示已经发放0表示没有2是激活
     */
    @TableField("code_state")
    private String codeState;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCodeState() {
        return codeState;
    }

    public void setCodeState(String codeState) {
        this.codeState = codeState;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TbInvitationCode{" +
        ", id=" + id +
        ", openId=" + openId +
        ", invitationCode=" + invitationCode +
        ", state=" + state +
        ", codeState=" + codeState +
        "}";
    }
}
