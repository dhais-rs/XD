package com.js.xd.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.js.xd.config.ServiceException;
import com.js.xd.mapper.XDOwnerMapper;
import com.js.xd.model.XDOwner;
import com.js.xd.service.XDOwnerService;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 车主用户接口实现类
 * @since 2020-3-18
 * @author fj
 */
@Component
public class XDOwnerServiceImpl extends ServiceImpl<XDOwnerMapper, XDOwner> implements XDOwnerService {

    /**
     * 分页查询车主审核信息
     * @param params
     * @return
     */
    @Override
    public Page<XDOwner> queryOwnerPage(Map<String, Object> params){
        //分页参数
        Page<XDOwner> page = new Page<XDOwner>(Integer.parseInt(params.get("current").toString()),Integer.parseInt(params.get("size").toString()));
        Wrapper<XDOwner> wrapper = new EntityWrapper<>();
        //        审核状态
        if(params.get("examine")!=null&&params.get("examine").toString().length()!=0){
            if("4".equals(params.get("examine").toString())){
                wrapper.eq("examine","4");
            }else if("3".equals(params.get("examine").toString())){
                wrapper.eq("examine","3");
            }else{
                wrapper.notIn("examine","4");
                wrapper.notIn("examine","3");
            }
        }
        //姓名
        if(params.get("name")!=null&&params.get("name").toString().length()!=0){
            wrapper.eq("name",params.get("name"));
        }
        //车牌号
        if(params.get("carNum")!=null&&params.get("carNum").toString().length()!=0){
            wrapper.eq("CAR_NUM",params.get("carNum"));
        }
        //开始时间
        if(params.get("startDate")!=null&&params.get("startDate").toString().length()!=0){
            wrapper.eq("DATE_FORMAT(created_by,'%Y-%m-%d')",params.get("startDate"));
        }
        //结束时间
        if(params.get("endDate")!=null&&params.get("endDate").toString().length()!=0){
            wrapper.eq("DATE_FORMAT(created_by,'%Y-%m-%d')",params.get("endDate"));
        }
        List<XDOwner> results = baseMapper.selectPage(page,wrapper);
        page.setRecords(results);
        return page;
    }

    /**
     * 通过或不通过审核处理
     * @param params
     */
    @Override
    public void passOrNotExamine(Map<String,String> params){
        String ids = params.get("ids");
        String flag = params.get("flag");
        if(ids!=null&&ids.length()!=0){
            Wrapper<XDOwner> wrapper = new EntityWrapper<>();
            XDOwner xdOwner = new XDOwner();
            if("1".equals(flag)){
                xdOwner.setExamine("1");
            }else if("2".equals(flag)){
                xdOwner.setExamine("2");
            }
            wrapper.in("id",ids.split(","));
            baseMapper.update(xdOwner,wrapper);
        }
    }

    /**
     * 提交申请审核
     * @param owner
     * @throws ServiceException
     */
    @Override
    public void addExamineData(XDOwner owner) throws ServiceException {
        if(!"0".equals(owner.getExamine()))
            owner.setExamine("3");
        owner.setCreatedTime(new Date());
        Wrapper<XDOwner> wrapper = new EntityWrapper<>();
        if(owner.getOpenId().length()==0)
            throw new ServiceException("id不能为空！");
        wrapper.eq("open_id",owner.getOpenId());
//        wrapper.and("(examine='0' or examine='1' or examine='2')");
        List<XDOwner> ownerList = baseMapper.selectList(wrapper);
        if(ownerList!=null&&!ownerList.isEmpty()){
            String status = ownerList.get(0).getExamine();
            if("2".equals(status)||"0".equals(status)){
                Wrapper<XDOwner> examineWrapper = new EntityWrapper<>();
                examineWrapper.eq("open_id",owner.getOpenId());
                if(!"0".equals(owner.getExamine()))
                    baseMapper.update(owner,examineWrapper);
            }else {
                throw new ServiceException("您已申请过审核了！");
            }
        }else{
            baseMapper.insert(owner);
        }
    }

    /**
     * 查询审核状态
     * @param openId
     * @return
     */
    @Override
    public String getExamineStatus(String openId){
        Wrapper<XDOwner> wrapper = new EntityWrapper<>();
        wrapper.eq("open_id",openId);
        wrapper.setSqlSelect("examine");
        List<XDOwner> result = baseMapper.selectList(wrapper);
        if(result!=null&&!result.isEmpty()){
            return result.get(0).getExamine();
        }else{
            return "0";
        }
    }
    /**
     * 审核是否通过
     * @param openId
     * @return
     */
    @Override
    public XDOwner getOwnerExamineFlag(String openId){
        Wrapper<XDOwner> wrapper = new EntityWrapper<>();
        wrapper.eq("open_id",openId);
        wrapper.eq("EXAMINE","1");
        List<XDOwner> result = baseMapper.selectList(wrapper);
        if(result!=null&&!result.isEmpty()){
            return result.get(0);
        }else{
            return null;
        }
    }
}
