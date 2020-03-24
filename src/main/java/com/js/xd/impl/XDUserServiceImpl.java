package com.js.xd.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.js.xd.mapper.UserMapper;
import com.js.xd.mapper.XDPushDataMapper;
import com.js.xd.model.User;
import com.js.xd.model.XDPushData;
import com.js.xd.service.XDPushDataService;
import com.js.xd.service.XDUserService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 管理员用户接口实现类
 * @since 2020-3-18
 * @author fj
 */
@Component
public class XDUserServiceImpl extends ServiceImpl<UserMapper, User> implements XDUserService {

}
