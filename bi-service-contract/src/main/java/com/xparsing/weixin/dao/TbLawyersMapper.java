package com.xparsing.weixin.dao;

import com.xparsing.weixin.entity.Content;
import com.xparsing.weixin.entity.TbLawyers;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lx
 * @since 2018-08-27
 */
public interface TbLawyersMapper extends BaseMapper<TbLawyers> {
    public int findByLawyerCount(Content content);


}
