package com.xparsing.weixin.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.xparsing.weixin.entity.Content;
import com.xparsing.weixin.service.impl.ContentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lx
 * @since 2018-08-13
 */
@RestController
//@EnableConfigurationProperties({Content.class})
public class ContentController {
    @Autowired
    ContentServiceImpl contentService;
  /*  @Autowired
    Content content;*/
    //读取属性配置文件@Value("${属性名}")
    @Value("${my.name}")
    private String name;


   @RequestMapping("/search/{id}")
    public Object findBycondition(@PathVariable("id") Integer id){
     /*   if("".equals(time)||time==null){
            //如果时间为空，默认当前年份
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            time =   sdf.format(new Date());
        }
        if("".equals(area)||area==null){
            area =   "10";
        }
        Content content = new Content();
        content.setReason(reason);
        content.setReleaseDate(time);
        content.setCourt(area);*/
       System.out.print(name);//16
       Content content1 =  contentService.selectById(id);
       // 查询姓名为‘张三’的所有用户记录
       List<Content> userList = contentService.selectList(
               new EntityWrapper<Content>().eq("name", "张三")
       );
   //    List<Content> contents =  contentService.finbByCondition(content);
       return content1;
    }
    @RequestMapping(value = "/miya")
    public Object testM(){
        System.out.print(name);
       /* System.out.print(content.getId());*/
        return name;
    }

}

