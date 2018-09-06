package com.xparsing.weixin.service;

import com.xparsing.weixin.entity.Content;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lx
 * @since 2018-08-27
 */
public interface ContentService extends IService<Content> {
    //根据案由和时间和地区 查询的数据有
    //案件数量、法官、律师的人数
    public Map findByReasonAndCourtidAndLawdate(String reason, String area, String date);
    public List findLawerByReasonAndCourtidAndLawdate(String reason, String area, String date);
    public List findJudgeByReasonAndCourtidAndLawdate(String reason, String area, String date);
}
