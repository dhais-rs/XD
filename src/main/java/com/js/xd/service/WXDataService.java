package com.js.xd.service;

import org.springframework.stereotype.Service;

/**
 * 微信信息交互接口
 * @since 2020-3-18
 * @author fj
 */
@Service
public interface WXDataService {
    String getWXOpenId(String wxCode) throws Exception;
}
