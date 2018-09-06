package com.xparsing.weixin.controller;


import com.xparsing.weixin.entity.TbInvitationCode;
import com.xparsing.weixin.service.TbInvitationCodeService;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lx
 * @since 2018-09-06
 */
@RestController
@RequestMapping("/invitedUser")
@Slf4j
public class TbInvitationCodeController {
    @Autowired
    private TbInvitationCodeService tbInvitationCodeService;
    @Value("${weixin.url}")
    private String url;
    @Value("${weixin.appid}")
    private String appid;
    @Value("${weixin.secret}")
    private String secret;

    /**
     * 根据openid查找是否存在 如果存在直接返回true
     * 如果不存在 返回false 输验证码
     * 验证验证码时候被使用 如果使用返回false
     * 如果没有使用返回true并保存openid
     * @param openId
     * @param invitationCode
     * @return
     */
    @RequestMapping("/checkDataAndSaveInvitedUser")
    public Object isExistenceInvitationCode(@RequestParam String openId, String invitationCode){
        String isInvitationCode = tbInvitationCodeService.fingdByCode(invitationCode,openId);
        Map<String ,String> reasultMap = new HashMap<>();
        //isInvitationCode 1 成功  2没有 3已使用
        reasultMap.put("code","1");
        reasultMap.put("checkResult",isInvitationCode);
        if("1".equals(isInvitationCode)){
            reasultMap.put("msg","成功");
        }else if("2".equals(isInvitationCode)){
            reasultMap.put("msg","邀请码错误");
        }else if("3".equals(isInvitationCode)){
            reasultMap.put("msg","邀请码已被使用");
        }

        return reasultMap;
    }

    /**
     *根据openid查找是否存在 如果存在直接返回true
     * @param openId
     * @return
     */
    @RequestMapping("/checkInvitedUserByOpenId")
    public Object isExistenceOpenId(@RequestParam String openId){
        boolean isOpenId = tbInvitationCodeService.fingByOpenId(openId);
        Map<String ,String> reasultMap = new HashMap<>();
        //有返回时1  没有返回是0
        if(isOpenId==true){
            reasultMap.put("code","1");
            //表示openid存在
            reasultMap.put("checkResult","1");

        }else{
            reasultMap.put("code","1");
            //表示openId不存在
            reasultMap.put("checkResult","0");
        }
        reasultMap.put("msg","");
        return reasultMap;
    }

    /**
     *
     * @param jsCode
     * @return
     */
    @RequestMapping("/getOpenIdByJsCode")
    public Object getOpenId(@RequestParam String jsCode){
        log.info("---------->进入获取openid");
        //url=url.replace("APPID", appid).replace("SECRET", secret).replace("JSCODE", jsCode);
        String apiUrl = "";
        apiUrl = url+"appid="+appid+"&secret="+secret+"&js_code="+jsCode+"&grant_type=authorization_code";
        HttpPost hp=new HttpPost(apiUrl);
        Map<String,Object> reasultMap = new HashMap<>();
        String result = "";
        try {
            HttpResponse response = HttpClients.createDefault().execute(hp);
            if(response.getStatusLine().getStatusCode()==200){
                result = EntityUtils.toString(response.getEntity());
                JSONObject jsonObject = JSONObject.fromObject(result);
                Object openid = jsonObject.get("openid");
                log.info("获取openid结束openid："+result);
                log.info("获取openid结束openid："+openid);
                //  return openid==null?null:openid.toString();
                reasultMap.put("code","1");
                reasultMap.put("result",jsonObject);
                return reasultMap;

            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
        }
        reasultMap.put("code","0");
        reasultMap.put("result",result);
        return reasultMap;
    }

    /**
     * 生成邀请码
     * @return
     */
    @RequestMapping("/createInvitationCode")
    public Object createInvitationCode(){
       List<TbInvitationCode> list =  tbInvitationCodeService.createInvitationCode();
        return list;
    }

    /**
     * 查看所有可用的邀请码
     * @return
     */
    @RequestMapping("/findUsableCode")
    public Object findUsableCode(){
        List<TbInvitationCode> list =  tbInvitationCodeService.findUsableCode();
        return list;
    }


}

