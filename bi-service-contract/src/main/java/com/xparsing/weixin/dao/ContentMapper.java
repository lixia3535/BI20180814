package com.xparsing.weixin.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xparsing.weixin.entity.Content;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lx
 * @since 2018-08-13
 */
public interface ContentMapper extends BaseMapper<Content> {
    List<Content> finbByCondition(Content content);

}
