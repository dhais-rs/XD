package com.js.xd.service;

import com.baomidou.mybatisplus.service.IService;
import com.js.xd.model.XDNewData;
import com.js.xd.model.XDPushData;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 公布信息数据接口
 * @since 2020-3-19
 * @author fj
 */
@Service
public interface XDNewDataService extends IService<XDNewData> {
    List<XDNewData> getNewDataInfo();
    XDNewData getDetails(String id);
}