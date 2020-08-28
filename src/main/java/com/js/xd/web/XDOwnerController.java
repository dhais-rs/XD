package com.js.xd.web;

import com.baomidou.mybatisplus.plugins.Page;
import com.js.xd.config.ServiceException;
import com.js.xd.model.XDOwner;
import com.js.xd.service.XDOwnerService;
import com.js.xd.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/XDOwner")
@Api(value="车主信息接口", description = "车主信息接口")
public class XDOwnerController {

    @Autowired
    private XDOwnerService service;

    @PostMapping("/queryOwner")
    @ApiOperation("获取车主审核数据")
    public Object queryOwnerPage(@RequestBody  Map<String,Object> params){
        Page<XDOwner> result = service.queryOwnerPage(params);
        return ResultUtil.success(result.getTotal(),result.getRecords(),"获取成功");
    }
    @PostMapping("/examine")
    @ApiOperation("审核数据")
    public Object passOrNotExamine(@RequestBody Map<String,String> params){
        service.passOrNotExamine(params);
        return ResultUtil.success("操作成功！");
    }
    @PostMapping("/addExamineData")
    @ApiOperation("申请审核")
    public Object addExamineData(@RequestBody XDOwner params) {
        try {
            service.addExamineData(params);
        } catch (ServiceException e) {
            return ResultUtil.fail(e.getMessage());
        }
        return ResultUtil.success("操作成功！");
    }

    @PostMapping("/getExamineStatus")
    @ApiOperation("查询审核状态")
    public Object getExamineStatus(@RequestBody Map<String,String> params){
        String openId = params.get("openId");
        String result = service.getExamineStatus(openId);
        return ResultUtil.success(1,result,"查询成功！");
    }

    @PostMapping("/getOwnerExamineFlag")
    @ApiOperation("根据openid查询审核通过数据")
    public Object getOwnerExamineFlag(@RequestBody Map<String,String> params){
        String openId = params.get("openId");
        XDOwner result = service.getOwnerExamineFlag(openId);
        return ResultUtil.success(1,result,"查询成功！");
    }
}
