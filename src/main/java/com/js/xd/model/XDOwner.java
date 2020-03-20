package com.js.xd.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * 车主信息实体类
 * @since 2020-3-18
 * @author fj
 */
@TableName("XD_Owner")
public class XDOwner implements Serializable{
    /** id;自增id */
    @TableId(value = "ID",type = IdType.AUTO)
    private Integer id ;
    /** 微信唯一标识 */
    @TableField("OPEN_ID")
    private String openId ;
    /** 车牌号 */
    @TableField("car_Num")
    private String carNum ;
    /** 车辆照片;车辆照片路径 */
    @TableField("car_Photo")
    private String carPhoto ;
    /** 真实姓名 */
    @TableField("name")
    private String name ;
    /** 车主身份证号 */
    @TableField("id_Card")
    private String idCard ;
    /** 是否审核通过;0：未审核1：审核通过2：审核不通过3：审核中 */
    @TableField("examine")
    private String examine ;
    /** 创建人 */
    @TableField("created_By")
    private String createdBy ;
    /** 创建时间 */
    @TableField("created_Time")
    private Date createdTime ;
    /** 更新人 */
    @TableField("updated_By")
    private String updatedBy ;
    /** 更新时间 */
    @TableField("updated_Time")
    private Date updatedTime ;

    /** id;自增id */
    public Integer getId(){
        return this.id;
    }
    /** id;自增id */
    public void setId(Integer id){
        this.id = id;
    }
    /** 微信唯一标识 */
    public String getOpenId(){
        return this.openId;
    }
    /** 微信唯一标识 */
    public void setOpenId(String openId){
        this.openId = openId;
    }
    /** 车牌号 */
    public String getCarNum(){
        return this.carNum;
    }
    /** 车牌号 */
    public void setCarNum(String carNum){
        this.carNum = carNum;
    }
    /** 车辆照片;车辆照片路径 */
    public String getCarPhoto(){
        return this.carPhoto;
    }
    /** 车辆照片;车辆照片路径 */
    public void setCarPhoto(String carPhoto){
        this.carPhoto = carPhoto;
    }
    /** 真实姓名 */
    public String getName(){
        return this.name;
    }
    /** 真实姓名 */
    public void setName(String name){
        this.name = name;
    }
    /** 车主身份证号 */
    public String getIdCard(){
        return this.idCard;
    }
    /** 车主身份证号 */
    public void setIdCard(String idCard){
        this.idCard = idCard;
    }
    /** 是否审核通过;0：未审核1：审核通过2：审核不通过3：审核中 */
    public String getExamine(){
        return this.examine;
    }
    /** 是否审核通过;0：未审核1：审核通过2：审核不通过3：审核中 */
    public void setExamine(String examine){
        this.examine = examine;
    }
    /** 创建人 */
    public String getCreatedBy(){
        return this.createdBy;
    }
    /** 创建人 */
    public void setCreatedBy(String createdBy){
        this.createdBy = createdBy;
    }
    /** 创建时间 */
    public Date getCreatedTime(){
        return this.createdTime;
    }
    /** 创建时间 */
    public void setCreatedTime(Date createdTime){
        this.createdTime = createdTime;
    }
    /** 更新人 */
    public String getUpdatedBy(){
        return this.updatedBy;
    }
    /** 更新人 */
    public void setUpdatedBy(String updatedBy){
        this.updatedBy = updatedBy;
    }
    /** 更新时间 */
    public Date getUpdatedTime(){
        return this.updatedTime;
    }
    /** 更新时间 */
    public void setUpdatedTime(Date updatedTime){
        this.updatedTime = updatedTime;
    }
}
