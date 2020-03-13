package com.js.xd.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.js.xd.mapper.UserMapper;
import com.js.xd.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@Api(value="swagger 测试接口", description = "swagger 测试接口")
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("bbb")
    @ResponseBody
    @ApiOperation("数据库测试接口")
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
//        return user;
        return userMapper.aaa();
    }

    @PostMapping("selectCars")
    @ApiOperation("数据接受，返回测试接口")
    public Object selectCars(@RequestBody Map<String,Object> params){
        Map<String,Object> result = params;
        params.put("test","testData");
        return result;
    }
}
