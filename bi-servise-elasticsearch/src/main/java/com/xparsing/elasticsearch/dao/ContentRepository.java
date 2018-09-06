package com.xparsing.elasticsearch.dao;

import com.xparsing.elasticsearch.entity.Content;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by user on 2018/8/28.
 */
@Component
public interface ContentRepository  {
    //public interface ContentRepository extends ElasticsearchRepository<Content,String> {
    //根据律师去查找
    //public List<Content> findByAgent(String agent, PageRequest pageable);
    //根据案由去查找
   // public List<Content> findByReason(String reason,PageRequest pageable);
    //根据案由时间 地区去查询
   // public List<Content> findByReasonAndLawDateAndCityId(String reason,String LawData,String cityId,PageRequest pageable);


}
