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
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    /**
     * 获取当前公布的信息PC
     * @return
     */
    @Override
    public List<XDNewData> getNewDataInfoForPC(Map<String, Object> params) {
        Wrapper<XDNewData> wrapper = new EntityWrapper<>();
        if(params.get("startDate")!=null&&params.get("startDate").toString().length()!=0){
            wrapper.ge("DATE_FORMAT(CREATED_TIME,'%Y-%m-%d')",params.get("startDate"));
        }
        if(params.get("endDate")!=null&&params.get("endDate").toString().length()!=0){
            wrapper.le("DATE_FORMAT(CREATED_TIME,'%Y-%m-%d')",params.get("endDate"));
        }
        if(params.get("state")!=null&&params.get("state").toString().length()!=0){
            wrapper.le("display",params.get("state"));
        }
        List<XDNewData> xdNewDataList = baseMapper.selectList(wrapper);
        return xdNewDataList;
    }

    /**
     * 获取信息详情
     * @param id
     * @return
     */
    @Override
    public XDNewData getDetails(String id) {
        return baseMapper.selectById(id);
    }

    /**
     * 更新公布信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updataNewDataInfo(List<XDNewData> xDNewDatas) {
        for(XDNewData item:xDNewDatas){
            Wrapper<XDNewData> newDataWrapper = new EntityWrapper<>();
            newDataWrapper.eq("id",item.getId());
            item.setCreatedBy(null);
            item.setCreatedTime(null);
            item.setId(null);
            item.setUpdatedTime(new Date());
            baseMapper.update(item,newDataWrapper);
        }
    }

    /**
     * 根据id批量关闭激活公布数据
     * @param params
     */
    @Override
    public void updateNewState(Map<String, String> params){
        String flag = params.get("flag"); //关闭/激活 标识 0关闭 1激活
        String ids = params.get("ids");
        if("0".equals(flag)){
            Wrapper<XDNewData> wrapper = new EntityWrapper<>();
            wrapper.in("id",ids.split(","));
            XDNewData xdNewData = new XDNewData();
            xdNewData.setDisplay("1");
            baseMapper.update(xdNewData,wrapper);
        }else{
            Wrapper<XDNewData> wrapper = new EntityWrapper<>();
            wrapper.in("id",ids.split(","));
            XDNewData xdNewData = new XDNewData();
            xdNewData.setDisplay("0");
            baseMapper.update(xdNewData,wrapper);
        }
    }

    /**
     * 新增公布数据
     * @param xdNewData
     */
    @Override
    public void addNewData(XDNewData xdNewData){
        xdNewData.setCreatedTime(new Date());
        baseMapper.insert(xdNewData);
    }
}
