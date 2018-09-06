package com.xparsing.weixin.dao;

import com.xparsing.weixin.entity.Content;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lx
 * @since 2018-08-27
 */
public interface ContentMapper extends BaseMapper<Content> {
    /**
     * 查找律师的个数
     * @param content
     * @return
     */
    public List<Map> findByLawyerCount(Content content);

    public List<Map>  findByJudgeCount(Content content);
   //  <!--根据案由 时间 地区 查询法官打官司的数量-->
    public List<Map>  findJudgeByReasonAndCourtidAndLawdate(Content content);
    //  <!--根据案由 时间 地区 查询律师打官司的数量-->
    public List<Map>  findLawerByReasonAndCourtidAndLawdate(Content content);

    public int findCaseCountByReason(Content content);
}
