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

    @PostMapping("/getNewDataForPc")
    @ApiOperation("获取公布的信息数据PC")
    public Object getNewDataInfoForPC(@RequestBody Map<String,Object> params){
        List<XDNewData> results = xdNewDataService.getNewDataInfoForPC(params);
        return ResultUtil.success(results.size(),results,"获取成功");
    }

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

    @PostMapping("/addNewData")
    @ApiOperation("新增公布信息数据")
    public Object addNewData(@RequestBody XDNewData newData){
        xdNewDataService.addNewData(newData);
        return ResultUtil.success("新增成功");
    }

    @PostMapping("/updateNewData")
    @ApiOperation("修改公布信息数据")
    public Object updateNewData(@RequestBody List<XDNewData> newDatas){
        xdNewDataService.updataNewDataInfo(newDatas);
        return ResultUtil.success("修改成功");
    }

    @PostMapping("/updateNewState")
    @ApiOperation("公布信息数据关闭激活")
    public Object updateNewState(@RequestBody Map<String,String> newDatas){
        xdNewDataService.updateNewState(newDatas);
        return ResultUtil.success("操作成功");
    }
}
