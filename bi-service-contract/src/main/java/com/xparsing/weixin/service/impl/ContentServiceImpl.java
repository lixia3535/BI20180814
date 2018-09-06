package com.xparsing.weixin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.xparsing.weixin.entity.Content;
import com.xparsing.weixin.dao.ContentMapper;
import com.xparsing.weixin.service.ContentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lx
 * @since 2018-08-27
 */
@Service
@Transactional
public class ContentServiceImpl extends ServiceImpl<ContentMapper, Content> implements ContentService {
    @Autowired
    ContentMapper contentMapper;

    /**
     * 根据案由和时间和地区 查询案件数量、法官、律师的人数
     * @param reason
     * @param area
     * @param date
     * @return
     */
    @Override
    public Map findByReasonAndCourtidAndLawdate(String reason, String area, String date) {
        EntityWrapper<Content> ew = new EntityWrapper<Content>();
        //这儿区域转化一下  area
        //案件数据量
        Content content = new Content();
        content.setReason(reason);
        content.setLawDate(date);
        //默认天津
        content.setCityId(area);
        int caseCount =  contentMapper.findCaseCountByReason(content);
       //对应律师人数
        List<Map> lawyerCount = contentMapper.findByLawyerCount(content);
        //对应法官人数
        List<Map> jugdeCount = contentMapper.findByJudgeCount(content);
        Map<String ,String> caseMap = new HashMap();
        caseMap.put("caseCount",caseCount+"");
        caseMap.put("lawyerCount",lawyerCount.size()+"");
        caseMap.put("jugdeCount",jugdeCount.size()+"");
        return caseMap;
    }

    /**
     *律师的名字，律师所打官司的数量 排序
     * @param reason
     * @param area
     * @param date
     * @return
     */
    public List findLawerByReasonAndCourtidAndLawdate(String reason, String area, String date){
        //律师的名字，律师所打官司的数量 排序
        //这儿区域转化一下  area
        //案件数据量
        Content content = new Content();
        content.setReason(reason);
        content.setLawDate(date);
        //默认天津
        content.setCityId(area);
       List<Map> list =  contentMapper.findLawerByReasonAndCourtidAndLawdate(content);



        return list;
    }


    public List findJudgeByReasonAndCourtidAndLawdate(String reason, String area, String date){
        Content content = new Content();
        content.setReason(reason);
        content.setLawDate(date);
        //默认天津
        content.setCityId(area);
        //默认天津
        content.setCityId(area);
        List<Map> list =  contentMapper.findJudgeByReasonAndCourtidAndLawdate(content);
        //  return list;
        return list;

    }



}
