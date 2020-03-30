package com.js.xd.web;

import com.js.xd.model.XDPushData;
import com.js.xd.service.XDPushDataService;
import com.js.xd.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pushData")
@Api(value="发布信息接口", description = "公布信息接口")
public class XDPushDataController {

    @Autowired
    private XDPushDataService xdPushDataService;

    @PostMapping("selectCars")
    @ApiOperation("查询发布的车辆信息")
    public Object selectCars(@RequestBody Map<String, Object> params) {
        List<XDPushData> result = xdPushDataService.getPushCarsInfo(params);
        return ResultUtil.success(result.size(),result,"获取成功");
    }

    @PostMapping("getPushCarDetails")
    @ApiOperation("查询发布的车辆信息明细")
    public Object getPushCarDetails(@RequestBody Map<String, Object> params) {

        return ResultUtil.success(1, xdPushDataService.getPushCarsInfoDetails(Integer.parseInt(params.get("id").toString())), "获取成功");
    }

    @PostMapping("delPushCarsInfo")
    @ApiOperation("根据id删除数据")
    public Object delPushCarsInfo(@RequestBody Map<String, Object> params){
        xdPushDataService.delPushCarsInfo(params.get("id").toString());
        return ResultUtil.success("操作成功！");
    }
    @GetMapping("queryTatolData")
    @ApiOperation("根据id删除数据")
    public Object queryTatolData(){
        Map<String,Object> result = xdPushDataService.queryTatolData();
        return ResultUtil.success(1,result,"");
    }
}
