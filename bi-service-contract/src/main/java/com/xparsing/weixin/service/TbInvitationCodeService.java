package com.xparsing.weixin.service;

import com.xparsing.weixin.entity.TbInvitationCode;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lx
 * @since 2018-09-06
 */
public interface TbInvitationCodeService extends IService<TbInvitationCode> {
    public boolean fingByOpenId(String openId);
    public String fingdByCode(String invitationCode,String openId);
    public boolean updateOpenId(TbInvitationCode tbInvitationCode);
    public List<TbInvitationCode> createInvitationCode();
    public List<TbInvitationCode> findUsableCode();

}
