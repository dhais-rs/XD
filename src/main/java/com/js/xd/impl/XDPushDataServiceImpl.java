package com.js.xd.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.js.xd.mapper.XDPushDataMapper;
import com.js.xd.model.XDPushData;
import com.js.xd.service.XDPushDataService;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 车主发布信息数据接口实现类
 * @since 2020-3-18
 * @author fj
 */
@Component
public class XDPushDataServiceImpl extends ServiceImpl<XDPushDataMapper,XDPushData> implements XDPushDataService {
    /**
     * 条件查询已发布信息
     * @param params
     * @return List<XDPushData>
     */
    @Override
    public List<XDPushData> getPushCarsInfo(Map<String,Object> params) {
        Wrapper<XDPushData> wrapper = new EntityWrapper<>();
        if(params.get("date")!=null&&params.get("date").toString().length()!=0)
            wrapper.ge("DATE_FORMAT(dep_date,'%Y-%m-%d')",params.get("date").toString());
        if(params.containsKey("startPosition")&&params.get("startPosition").toString().length()!=0)
            wrapper.like("dep_position",params.get("startPosition").toString());
        if(params.containsKey("endPosition")&&params.get("endPosition").toString().length()!=0)
            wrapper.like("des_position",params.get("endPosition").toString());
        if(params.containsKey("depDetail")&&params.get("depDetail").toString().length()!=0)
            wrapper.like("dep_Detail",params.get("depDetail").toString());
        if(params.containsKey("pNum")&&params.get("pNum").toString().length()!=0)
            wrapper.ge("seat_num",params.get("pNum"));
        wrapper.eq("state","0");
        wrapper.orderBy("dep_date",true);
//        wrapper.setSqlSelect("id,dep_date,dep_position,des_position,seat_num,created_By");
        List<XDPushData> resultList = baseMapper.selectList(wrapper);
        return resultList;
    }

    /**
     * 获取详情
     * @param id
     * @return
     */
    @Override
    public XDPushData getPushCarsInfoDetails(Integer id) {
        XDPushData xdPushData = baseMapper.selectById(id);
        return xdPushData;
    }

    /**
     * 根据id删除数据
     * @param id
     */
    @Override
    public void delPushCarsInfo(String id){
        Wrapper<XDPushData> wrapper = new EntityWrapper<>();
        wrapper.eq("id",id);
        XDPushData xdPushData = new XDPushData();
        xdPushData.setState("1");
        baseMapper.update(xdPushData,wrapper);
    }

    /**
     * 获取发布信息汇总
     */
    @Override
    public Map<String,Object> queryTatolData(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Wrapper<XDPushData> wrapper = new EntityWrapper<>();
        wrapper.eq("DATE_FORMAT(CREATED_TIME,'%Y-%m-%d')",sdf.format(new Date()));
        Integer total =  baseMapper.selectCount(null);
        Integer current =  baseMapper.selectCount(wrapper);
        Map<String,Object> result = new HashMap<>();
        result.put("total",total);
        result.put("current",current);
        return result;
    }
}
