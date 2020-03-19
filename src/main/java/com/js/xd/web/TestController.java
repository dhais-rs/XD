package com.js.xd.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.js.xd.mapper.UserMapper;
import com.js.xd.model.User;
import com.js.xd.service.WXDataService;
import com.js.xd.service.XDPushDataService;
import com.js.xd.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@Api(value="swagger 测试接口", description = "swagger 测试接口")
public class TestController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private WXDataService wxDataService;
    @Autowired
    private XDPushDataService xdPushDataService;

    @GetMapping("bbb")
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
    @ApiOperation("查询发布的车辆信息")
    public Object selectCars(@RequestBody Map<String,Object> params){

        return xdPushDataService.getPushCarsInfo(params);
    }

    @PostMapping("getPushCarDetails")
    @ApiOperation("查询发布的车辆信息明细")
    public Object getPushCarDetails(@RequestBody Map<String,Object> params){

        return ResultUtil.success(1,xdPushDataService.getPushCarsInfoDetails(Integer.parseInt(params.get("id").toString())),"获取成功");
    }

    @PostMapping("getWXopenid")
    @ApiOperation("调用微信接口获取openid")
    public Object getWXopenid(@RequestBody Map<String,String> params){
        try {
            String result = wxDataService.getWXOpenId(params.get("code"));
            return ResultUtil.success(1,result,"");
        } catch (Exception e) {
            return ResultUtil.fail(0,"获取openid失败，请重试！");
        }
    }
}
