package com.xparsing.weixin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.xparsing.weixin.entity.TbInvitationCode;
import com.xparsing.weixin.dao.TbInvitationCodeMapper;
import com.xparsing.weixin.service.TbInvitationCodeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lx
 * @since 2018-09-06
 */
@Service
@Slf4j
public class TbInvitationCodeServiceImpl extends ServiceImpl<TbInvitationCodeMapper, TbInvitationCode> implements TbInvitationCodeService {
    @Autowired
    private TbInvitationCodeMapper tbInvitationCodeMapper;
    @Value("${invitation.codeNum}")
    private int codeNum;
    @Override
    public boolean fingByOpenId(String openId) {
        List<TbInvitationCode> userList = tbInvitationCodeMapper.selectList(
                new EntityWrapper<TbInvitationCode>().eq("open_id",openId )
        );
        if(userList.size()!=1){
            return false;
        }
        return true;
    }

    @Override
    public String fingdByCode(String invitationCode, String openId) {
        List<TbInvitationCode> invitationCodeList = tbInvitationCodeMapper.selectList(
                new EntityWrapper<TbInvitationCode>().eq("invitation_code",invitationCode )
        );
        //1 成功  2没有 3已使用
        if(invitationCodeList.size()!=1){
            return "2";
        }else{
            //讲opnid存表里面
            TbInvitationCode tbInvitationCode = invitationCodeList.get(0);
            String dbOpenId = tbInvitationCode.getOpenId();
            if(dbOpenId!=null&&!"".equals(dbOpenId)){
                return "3";
            }else{
                tbInvitationCode.setOpenId(openId);
                //code_state 2表示已经激活 1表示已经发放  0表示没有使用
                tbInvitationCode.setCodeState("2");
                tbInvitationCodeMapper.updateById(tbInvitationCode);
                return "1";
            }

        }
    }

    @Override
    public boolean updateOpenId(TbInvitationCode tbInvitationCode) {
        try{
            tbInvitationCodeMapper.updateById(tbInvitationCode);
        }catch (Exception e){
            // System.out.print("保存openId失败");
            log.error("保存openId失败");
            return false;
        }

        return true;
    }

    @Override
    public List<TbInvitationCode> createInvitationCode() {
        List<TbInvitationCode> listInvitationCode = new ArrayList<>();
        //每调用一次生成100调随机码
        for(int i=0;i<codeNum;i++){
            TbInvitationCode tbInvitationCode = new TbInvitationCode();
            tbInvitationCode.setId(UUID.randomUUID().toString().replace("-",""));
            tbInvitationCode.setCodeState("0");
            tbInvitationCode.setState("1");
            tbInvitationCode.setInvitationCode((int)((Math.random()*9+1)*100000)+"");
            tbInvitationCodeMapper.insert(tbInvitationCode);
            listInvitationCode.add(tbInvitationCode);
        }
        return listInvitationCode;
    }

    @Override
    public List<TbInvitationCode> findUsableCode() {
        List<TbInvitationCode> invitationCodeList = tbInvitationCodeMapper.selectList(
                new EntityWrapper<TbInvitationCode>().eq("code_state","0")
        );
        return invitationCodeList;
    }
}
