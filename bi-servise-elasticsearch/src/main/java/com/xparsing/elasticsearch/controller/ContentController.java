package com.xparsing.elasticsearch.controller;

import com.xparsing.elasticsearch.entity.Content;
import com.xparsing.elasticsearch.service.ContentService;
import com.xparsing.elasticsearch.service.impl.ContentServiceImpl;
import com.xparsing.elasticsearch.utils.MysqlImportES;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by user on 2018/8/28.
 */
@RestController
@Slf4j
public class ContentController {
    @Autowired
    private ContentService contentService;
    @Autowired
    private TransportClient client;
    //根据律师去查找
    @RequestMapping("/listLawyers/{name}")
    public List findByLawyers(@PathVariable String name){
      /* List<Content> contentList =  contentService.findByAgent(name,new PageRequest(0,10));*/
        /*System.out.print("contentList的大小："+contentList.size());
        return contentList;*/
        return null;
    }

    @RequestMapping("/add")
    public void addContent(){
        try {
            List<Map<String,String>> list = MysqlImportES.WriteData("content");
            for(Map<String,String> map:list) {
                XContentBuilder content1 = XContentFactory.jsonBuilder().startObject()
                        .field("id", map.get("id"))
                        .field("name",map.get("name"))
                        .field("release_date",map.get("release_date"))
                        .field("content_definite",map.get("content_definite"))
                        .field("announcement",map.get("announcement"))
                        .field("law_type",map.get("law_type"))
                        .field("hearing_procedure",map.get("hearing_procedure"))
                        .field("law_date",map.get("law_date"))
                        .field("people",map.get("people"))
                        .field("reason",map.get("reason"))
                        .field("basis",map.get("basis"))
                        .field("judge",map.get("judge"))
                        .field("agent",map.get("agent"))
                        .field("plaintiff",map.get("plaintiff"))
                        .field("defendant",map.get("defendant"))
                        .field("legal_representative",map.get("legal_representative"))
                        .field("court_id",map.get("court_id"))
                        .field("city_id",map.get("city_id")).endObject();

              //  String id = String.valueOf(map.get("id"));
                IndexResponse result = this.client.prepareIndex("content", "doc", UUID.randomUUID().toString().replace("-","")).setSource(content1).get();
                //return new ResponseEntity(result.getId(), HttpStatus.OK);
            }
            log.info("数据导入es成功，一共导入"+list.size()+"条数据");
        } catch (IOException e) {
            log.info("数据导入es失败");
            e.printStackTrace();
        }

          /* Content content = new Content();
           content.setId(map.get("id"));
           content.setName(map.get("name"));
           content.setReleaseDate(map.get("release_date"));
           content.setContentDefinite(map.get("content_definite"));
           content.setAnnouncement(map.get("announcement"));
           content.setLawType(map.get("law_type"));
           content.setHearingProcedure(map.get("hearing_procedure"));
           content.setLawDate(map.get("law_date"));
           content.setPeople(map.get("people"));
           content.setReason(map.get("reason"));
           content.setBasis(map.get("basis"));
           content.setJudge(map.get("judge"));
           content.setAgent(map.get("agent"));
           content.setPlaintiff(map.get("plaintiff"));
           content.setDefendant(map.get("defendant"));
           content.setLegalRepresentative(map.get("legal_representative"));
           content.setCourtId(map.get("court_id"));
           content.setCityId(map.get("city"));
           contentService.add(content);*/


    }

    /**
     * IK分词器
     *
     * @param args
     * @throws IOException
     */
    public void IKAnalyzer(String[] args) throws IOException {
        Settings settings = Settings.EMPTY;
        IKAnalyzer analyzer = new IKAnalyzer();
        String text = "中华人民共和国国歌";
        StringReader stringReader = new StringReader(text);
        TokenStream tokenStream = analyzer.tokenStream("", stringReader);
        tokenStream.reset();
        CharTermAttribute term = tokenStream.getAttribute(CharTermAttribute.class);
        while (tokenStream.incrementToken()) {
            System.out.print(term.toString() + "—");
        }
        stringReader.close();
        tokenStream.close();

    }

    /**
     * c查询所有的
     */
    @RequestMapping("/queryAll")
    public Object queryAll(){
        QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
        SearchResponse searchResponse = client.prepareSearch("content").setQuery(queryBuilder).get();
        List aa = new ArrayList();
        for (SearchHit searchHit : searchResponse.getHits()) {
           Map<String ,Object> map =  searchHit.getSourceAsMap();

            System.out.println(searchHit.getSourceAsMap());
            aa.add(searchHit.getSourceAsMap());
        }
        return aa;

    }

    /**
     * 根据案由查询对应的数据
     * QueryBuilders.termQuery("field","text");是精确查找
     * QueryBuilders.matchQuery("field","text"); 字段值包含搜索
     * QueryBuilder prefix= QueryBuilders.prefixQuery("field","text"); 前缀搜索
     * FuzzyQueryBuilder fuzzy= QueryBuilders.fuzzyQuery(field, value); 模糊值搜索
     * QueryBuilder wildcard= QueryBuilders.wildcardQuery(field,patten); 通配符搜索
     * QueryBuilder queryString= QueryBuilders.queryStringQuery("queryString"); 搜索语句搜索
     *
     * @param reason
     * @return
     */
    @RequestMapping("/queryContentByCondition")
    public Object queryContentByCondition(@RequestParam String reason) {
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("reason", reason);

        SearchResponse response = client.prepareSearch("content").setQuery(queryBuilder).get();
        List aa = new ArrayList();
        for (SearchHit searchHit : response.getHits()) {
            Map<String, Object> map = searchHit.getSourceAsMap();

            System.out.println(searchHit.getSourceAsMap());
            aa.add(searchHit.getSourceAsMap());
        }

        return aa;
    }


}
