package com.xparsing.weixin.service.impl;

import com.xparsing.weixin.entity.Content;
import com.xparsing.weixin.dao.ContentMapper;
import com.xparsing.weixin.service.ContentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lx
 * @since 2018-09-06
 */
@Service
public class ContentServiceImpl extends ServiceImpl<ContentMapper, Content> implements ContentService {

}
