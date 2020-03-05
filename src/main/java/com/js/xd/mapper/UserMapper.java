package com.js.xd.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.js.xd.model.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper extends BaseMapper<User> {

    String aaa();
}
