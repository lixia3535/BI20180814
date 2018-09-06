package com.xparsing.weixin.controller;


import com.xparsing.weixin.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lx
 * @since 2018-08-27
 */
@RestController
@RequestMapping("/content")
public class ContentController {
    @Autowired
    ContentService contentService;
    /**
     *   //根据案由和时间和地区 查询的数据有
     //案件数量、法官、律师的人数
     * @param caseKeyword
     * @param caseYear
     * @param cityCode
     * @return
     */
    @RequestMapping("/findByReasonAndCourtidAndLawdate")
    public Object findByReasonAndCourtidAndLawdate(@RequestParam String caseKeyword,String caseYear,String cityCode){
        caseYear = caseYear+"-01-01";
       Map<String ,String> caseMap =  contentService.findByReasonAndCourtidAndLawdate(caseKeyword,cityCode,caseYear);
        caseMap.put("code","1");
        caseMap.put("msg","1");
       return caseMap;
    }

    /**
     * 根据案由时间地区查找对应律师的姓名以及排名
     * @param caseKeyword
     * @param caseYear
     * @param cityCode
     * @return
     */
    @RequestMapping("/findLawyersByReasonAndCourtidAndLawdate")
    public Map findLawyersByReasonAndCourtidAndLawdate(@RequestParam String caseKeyword,String caseYear,String cityCode){
        caseYear = caseYear+"-01-01";
        List<Map<String,Object>> list =  contentService.findLawerByReasonAndCourtidAndLawdate(caseKeyword,cityCode,caseYear);
        List<Map<String,Object>> listConRatio= computeRatio(list);
        //  return list;
        Map map = new HashMap();
        map.put("code","1");
        map.put("msg","1");
        map.put("dataList",listConRatio);

        return map;

    }

    /**
     *
     * 查询法官的名字及对应案由的处理的件数
     * @param caseKeyword
     * @param caseYear
     * @param cityCode
     * @return
     */
    @RequestMapping("/findJudgeByReasonAndCourtidAndLawdate")
    public Map findJudgeByReasonAndCourtidAndLawdate(@RequestParam String caseKeyword,String caseYear,String cityCode){
        caseYear = caseYear+"-01-01";
        List<Map<String,Object>> list =  contentService.findJudgeByReasonAndCourtidAndLawdate(caseKeyword,cityCode,caseYear);
        List<Map<String,Object>> listConRatio= computeRatio(list);
        Map map = new HashMap();
        map.put("code","1");
        map.put("msg","1");
        map.put("dataList",listConRatio);
        return map;


    }


    //算比例

    public List<Map<String,Object>> computeRatio(List<Map<String,Object>> list){
        int casetotailCount=0;
        for(Map<String,Object> lawyer:list){
            Long aa = (Long)lawyer.get("caseCount");
            int caseCount =  new Long(aa).intValue();
            if(!"".equals(caseCount)) {
                casetotailCount +=  caseCount;
            }
        }
        for(Map<String,Object> lawyer:list){
            Long aa = (Long)lawyer.get("caseCount");
            int caseCount =  new Long(aa).intValue();
            DecimalFormat df=new DecimalFormat("0.00");
            System.out.println(df.format((float)caseCount/casetotailCount*100));
            String ratio = df.format((float)caseCount/casetotailCount*100);
            lawyer.put("ratio",ratio);
         //   }


        }

        return list;
    }


}

