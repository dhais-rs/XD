package com.js.xd.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 车主信息数据实体类
 * @since 2020-3-18
 * @author fj
 */
@TableName("XD_PushData")
public class XDPushData implements Serializable {
    /** id */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id ;

    /** 微信唯一标识 */
    @TableField("open_Id")
    private String openId ;

    /** 出发时间 */
    @TableField("dep_Date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date depDate ;

    /** 出发地点 */
    @TableField("dep_Position")
    private String depPosition ;

    /** 出发详细地址 */
    @TableField("dep_Dateil")
    private String depDateil ;

    /** 目的地点 */
    @TableField("des_Position")
    private String desPosition ;

    /** 目的详细地址 */
    @TableField("des_Dateil")
    private String desDateil ;

    /** 联系电话 */
    @TableField("phone_Num")
    private String phoneNum ;

    /** 微信号 */
    @TableField("WX_Num")
    private String WXNum ;

    /** 剩余座位 */
    @TableField("seat_Num")
    private Integer seatNum ;

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

    public String getWXNum() {
        return WXNum;
    }

    public void setWXNum(String WXNum) {
        this.WXNum = WXNum;
    }

    /** id */
    public Integer getId(){
        return this.id;
    }
    /** id */
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
    /** 出发时间 */
    public Date getDepDate(){
        return this.depDate;
    }
    /** 出发时间 */
    public void setDepDate(Date depDate){
        this.depDate = depDate;
    }
    /** 出发地点 */
    public String getDepPosition(){
        return this.depPosition;
    }
    /** 出发地点 */
    public void setDepPosition(String depPosition){
        this.depPosition = depPosition;
    }
    /** 出发详细地址 */
    public String getDepDateil(){
        return this.depDateil;
    }
    /** 出发详细地址 */
    public void setDepDateil(String depDateil){
        this.depDateil = depDateil;
    }
    /** 目的地点 */
    public String getDesPosition(){
        return this.desPosition;
    }
    /** 目的地点 */
    public void setDesPosition(String desPosition){
        this.desPosition = desPosition;
    }
    /** 目的详细地址 */
    public String getDesDateil(){
        return this.desDateil;
    }
    /** 目的详细地址 */
    public void setDesDateil(String desDateil){
        this.desDateil = desDateil;
    }
    /** 联系电话 */
    public String getPhoneNum(){
        return this.phoneNum;
    }
    /** 联系电话 */
    public void setPhoneNum(String phoneNum){
        this.phoneNum = phoneNum;
    }
    /** 剩余座位 */
    public Integer getSeatNum(){
        return this.seatNum;
    }
    /** 剩余座位 */
    public void setSeatNum(Integer seatNum){
        this.seatNum = seatNum;
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
