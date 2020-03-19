package com.js.xd.impl;

import com.js.xd.service.WXDataService;
import com.js.xd.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 微信数据交互实现类
 * @since 2020-3-18
 * @author fj
 */
@Component
public class WXDataServiceImpl implements WXDataService {

    @Autowired
    HttpUtil httpUtil = new HttpUtil();

    @Override
    public String getWXOpenId(String wxCode) throws Exception {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx9c9474fac7b8834e&secret=730c1340bcc14f390a849c71a06e5ae8&js_code="+wxCode+"&grant_type=authorization_code";
        //调用微信接口获取openid
        String result = httpUtil.httpsGet(url);
        return result;
    }
}
