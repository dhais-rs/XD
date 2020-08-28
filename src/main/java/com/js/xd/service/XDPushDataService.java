package com.js.xd.service;

import com.baomidou.mybatisplus.service.IService;
import com.js.xd.model.XDPushData;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 发布信息数据接口
 * @since 2020-3-18
 * @author fj
 */
@Service
public interface XDPushDataService extends IService<XDPushData> {
    List<XDPushData> getPushCarsInfo(Map<String,Object> params);
    XDPushData getPushCarsInfoDetails(Integer id);
    /**
     * 根据id删除数据
     * @param id
     */
    void delPushCarsInfo(String id);
    /**
     * 获取发布信息汇总
     */
    Map<String,Object> queryTatolData();
    /**
     * 发布信息
     */
    void pushCarData(XDPushData pushData);
    /**
     * 获取个人发布历史
     * @param params
     * @return
     */
    List<XDPushData> queryPushDataHistory(Map<String, String> params);
}
