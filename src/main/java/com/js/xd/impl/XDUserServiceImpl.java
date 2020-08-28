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
import com.js.xd.util.AESEncryptUtil;
import com.js.xd.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理员用户接口实现类
 * @since 2020-3-18
 * @author fj
 */
@Component
public class XDUserServiceImpl extends ServiceImpl<UserMapper, User> implements XDUserService {

    /**
     * 管理员登录接口
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public Map<String,String> adminLogin(User user) throws Exception {

        Map<String,String> rows = new HashMap<>();
        String pad = AESEncryptUtil.desEncrypt(user.getPassword());
        user.setPassword(pad);
        Wrapper<User> userWrapper = new EntityWrapper<>();
        userWrapper.eq("userId",user.getUserId());
        userWrapper.eq("password",user.getPassword());
        List<User> flag = baseMapper.selectList(userWrapper);
        if(flag!=null&&!flag.isEmpty()){
            User userInfo = flag.get(0);
            String token = JWTUtil.getToken(user.getUserName());
            token = "Bearer:" + token;
            rows.put("token",token);
            rows.put("user",userInfo.getUserName());
            rows.put("level",userInfo.getLevel());
        }
        return rows;
    }
}
