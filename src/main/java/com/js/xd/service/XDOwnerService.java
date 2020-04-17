package com.js.xd.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.js.xd.config.ServiceException;
import com.js.xd.model.User;
import com.js.xd.model.XDOwner;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 车主用户接口
 * @since 2020-3-18
 * @author fj
 */
@Service
public interface XDOwnerService extends IService<XDOwner> {

    /**
     * 分页查询车主审核信息
     * @param params
     * @return
     */
    Page<XDOwner> queryOwnerPage(Map<String, Object> params);
    /**
     * 通过或不通过审核处理
     * @param params
     */
    void passOrNotExamine(Map<String, String> params);
    /**
     * 提交申请审核
     * @param owner
     * @throws ServiceException
     */
    void addExamineData(XDOwner owner) throws ServiceException;
    /**
     * 查询审核状态
     * @param openId
     * @return
     */
    String getExamineStatus(String openId);
    /**
     * 审核是否通过
     * @param openId
     * @return
     */
    XDOwner getOwnerExamineFlag(String openId);
}
