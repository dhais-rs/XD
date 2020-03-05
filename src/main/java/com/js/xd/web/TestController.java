package com.js.xd.web;


import com.js.xd.mapper.UserMapper;
import com.js.xd.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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
        User user = userMapper.selectById(1);
        return userMapper.aaa();
    }
}
