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
    /**
     * 获取当前公布的信息PC
     * @return
     */
    List<XDNewData> getNewDataInfoForPC(Map<String, Object> params);

    XDNewData getDetails(String id);

    void updataNewDataInfo(List<XDNewData> xDNewDatas);
    /**
     * 根据id批量关闭激活公布数据
     * @param params
     */
    void updateNewState(Map<String, String> params);
    /**
     * 新增公布数据
     * @param xdNewData
     */
    void addNewData(XDNewData xdNewData);
}
