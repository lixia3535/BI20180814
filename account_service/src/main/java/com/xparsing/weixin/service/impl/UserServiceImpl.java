package com.xparsing.weixin.service.impl;

import com.xparsing.weixin.entity.User;
import com.xparsing.weixin.dao.UserMapper;
import com.xparsing.weixin.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lx
 * @since 2018-09-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
