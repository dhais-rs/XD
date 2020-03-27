package com.js.xd.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.js.xd.mapper.UserMapper;
import com.js.xd.mapper.XDOwnerMapper;
import com.js.xd.model.User;
import com.js.xd.model.XDOwner;
import com.js.xd.service.XDOwnerService;
import com.js.xd.service.XDUserService;
import com.js.xd.util.AESEncryptUtil;
import com.js.xd.util.JWTUtil;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 车主用户接口实现类
 * @since 2020-3-18
 * @author fj
 */
@Component
public class XDOwnerServiceImpl extends ServiceImpl<XDOwnerMapper, XDOwner> implements XDOwnerService {


}
