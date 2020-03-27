package com.js.xd.service;

import com.baomidou.mybatisplus.service.IService;
import com.js.xd.model.User;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 管理员用户接口
 * @since 2020-3-18
 * @author fj
 */
@Service
public interface XDUserService extends IService<User> {

    /**
     * 管理员登录接口
     * @param user
     * @return
     * @throws Exception
     */
    Map<String,String> adminLogin(User user) throws Exception;
}
