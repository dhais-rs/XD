package com.js.xd.web;

import com.js.xd.model.XDNewData;
import com.js.xd.service.XDNewDataService;
import com.js.xd.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/newData")
@Api(value="公布信息接口", description = "公布信息接口")
public class XDNewDataController {

    @Autowired
    private XDNewDataService xdNewDataService;

    @PostMapping("/getNewData")
    @ApiOperation("获取当前公布的信息数据")
    public Object getNewDataInfo(){
        List<XDNewData> results = xdNewDataService.getNewDataInfo();
        return ResultUtil.success(results.size(),results,"获取成功");
    }
    @PostMapping("/getDetails")
    @ApiOperation("根据id获取信息详情")
    public Object getDetails(@RequestBody Map<String,Object> params){
        XDNewData result = xdNewDataService.getDetails(params.get("id").toString());
        return ResultUtil.success(1,result,"获取成功");
    }
}
