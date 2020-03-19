package com.js.xd.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据返回工具类
 * @since 2020-3-18
 * @author fj
 */
public class ResultUtil {

    public static Map<String,Object> success(Integer total ,Object rows,String info){
        Map<String,Object> data = new HashMap<>();
        data.put("code",1);
        data.put("info",info);
        data.put("total",total);
        data.put("rows",rows);
        data.put("timestamp",System.currentTimeMillis());
        return data;
    }
    public static Map<String,Object> fail(Integer total,String info){
        Map<String,Object> data = new HashMap<>();
        data.put("code",0);
        data.put("info",info);
        data.put("total",total);
        data.put("timestamp",System.currentTimeMillis());
        return data;
    }
}
