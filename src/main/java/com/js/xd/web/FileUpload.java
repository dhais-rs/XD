package com.js.xd.web;

import com.js.xd.util.FileNameUtil;
import com.js.xd.util.FileUploadUtil;
import com.js.xd.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RestController
@RequestMapping("/fileUpload")
@Api(value="公布信息接口", description = "公布信息接口")
public class FileUpload {

    @ApiOperation("图片上传")
    @ApiImplicitParam(name = "file", value = "文件", required = true, dataType = "File")
    @RequestMapping(value="/upload",method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Object upload(@RequestBody MultipartFile fileUpload, HttpServletRequest request) {
        //定义要上传文件 的存放路径
        String localPath="/root/javaService/XD/fileUpload/";
        //获得文件名字
        String fileName=fileUpload.getOriginalFilename();
        fileName= FileNameUtil.getFileName(fileName);
        File dest = new File(localPath + fileName);
        if(FileUploadUtil.upload(fileUpload, localPath, fileName)){
            // 将上传的文件写入到服务器端文件夹
            // 获取当前项目运气的完整url
            String requestURL = request.getRequestURL().toString();
            // 获取当前项目的请求路径url
            String requestURI = request.getRequestURI();
            // 得到去掉了uri的路径
            String url = requestURL.substring(0, requestURL.length()-requestURI.length() + 1);
            url="http://154.8.136.28/XD/static/images/"+ fileName;


            return  ResultUtil.success(url);

        }
        // 返回
        return ResultUtil.fail("未知错误导致上传失败");
    }
}
