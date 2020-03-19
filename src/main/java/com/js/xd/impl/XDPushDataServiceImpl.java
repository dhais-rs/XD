package com.js.xd.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.js.xd.mapper.XDPushDataMapper;
import com.js.xd.model.XDPushData;
import com.js.xd.service.XDPushDataService;
import org.springframework.stereotype.Component;

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
        wrapper.ge("dep_date",params.get("date"));
        wrapper.like("dep_position",params.get("startPosition").toString());
        wrapper.like("des_position",params.get("endPosition").toString());
        wrapper.ge("seat_num",params.get("pNum"));
        wrapper.orderBy("dep_date",true);
        wrapper.setSqlSelect("id,dep_date,dep_position,des_position,seat_num,created_By");
        List<XDPushData> resultList = baseMapper.selectList(wrapper);
        return resultList;
    }

    @Override
    public XDPushData getPushCarsInfoDetails(Integer id) {
        XDPushData xdPushData = baseMapper.selectById(id);
        return xdPushData;
    }
}
