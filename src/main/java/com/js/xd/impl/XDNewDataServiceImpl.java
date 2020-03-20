package com.js.xd.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.js.xd.mapper.XDNewDataMapper;
import com.js.xd.mapper.XDPushDataMapper;
import com.js.xd.model.XDNewData;
import com.js.xd.model.XDPushData;
import com.js.xd.service.XDNewDataService;
import com.js.xd.service.XDPushDataService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 公布信息接口实现类
 * @since 2020-3-19
 * @author fj
 */
@Component
public class XDNewDataServiceImpl extends ServiceImpl<XDNewDataMapper, XDNewData> implements XDNewDataService {

    /**
     * 获取当前公布的信息
     * @return
     */
    @Override
    public List<XDNewData> getNewDataInfo() {
        Wrapper<XDNewData> wrapper = new EntityWrapper<>();
        wrapper.eq("display","0");
        wrapper.orderBy("level",false);
        List<XDNewData> xdNewDataList = baseMapper.selectList(wrapper);
        return xdNewDataList;
    }

    @Override
    public XDNewData getDetails(String id) {
        return baseMapper.selectById(id);
    }
}
