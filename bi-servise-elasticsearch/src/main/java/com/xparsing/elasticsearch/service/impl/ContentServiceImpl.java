package com.xparsing.elasticsearch.service.impl;

/*import com.xparsing.elasticsearch.dao.ContentRepository;
import com.xparsing.elasticsearch.entity.Content;*/
import com.xparsing.elasticsearch.service.ContentService;
/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;*/
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2018/8/28.
 */
@Service
public class ContentServiceImpl implements ContentService{
   /* @Autowired
    private ContentRepository contentRepository;

    @Override
    public List<Content> findByAgent(String agent, PageRequest  pageable) {
        List<Content> contentList = contentRepository.findByAgent(agent,pageable);
        return contentList;
    }

    @Override
    public List<Content> findByReason(String reason, PageRequest  pageable) {
        List<Content> contentList = contentRepository.findByReason(reason,pageable);
        return contentList;
    }

    @Override
    public List<Content> findByReasonAndLawDateAndCityId(String reason, String LawData, String cityId, PageRequest pageable) {
        List<Content> contentList = contentRepository.findByReasonAndLawDateAndCityId(reason,LawData,cityId,pageable);
        return contentList;
    }

    @Override
    public void add(Content content) {
        contentRepository.save(content);
    }*/
}
