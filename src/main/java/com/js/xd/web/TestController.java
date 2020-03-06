package com.js.xd.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.js.xd.mapper.UserMapper;
import com.js.xd.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller("/")
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("bbb")
    @ResponseBody
    public Object getTest(){
//        List<String> aa = new ArrayList<String>();
//        aa.add("aaa");
//        aaa.getSession().setAttribute("aaaa","session:");
//        return aaa.getSession().getAttribute("aaaa")+aaa.getSession().getId();
//        String user = jdbc.queryForObject("select password from user where userId=? ",String.class,(123));
//        return user.toString()+"132123132123123";
//        return "aaa";
        //构建查询条件，使用wrapper构建条件  mybatis plus自带，wrapper的各种方法都有中文解释
        Wrapper<User> userWrapper = new EntityWrapper<>();
        userWrapper.eq("userid",1);
        //使用继承了mybatis plus提供的BaseMapper  就可以使用父类中的方法进行crud
        List<User> user = userMapper.selectList(userWrapper);
        return user;
    }
}
