package com.js.xd.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("id")
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
    @TableField("dep_Detail")
    private String depDetail ;

    /** 目的地点 */
    @TableField("des_Position")
    private String desPosition ;

    /** 目的详细地址 */
    @TableField("des_Detail")
    private String desDetail ;

    /** 联系电话 */
    @TableField("phone_Num")
    private String phoneNum ;

    /** 微信号 */
    @TableField("WX_Num")
    private String WXNum ;

    /** 剩余座位 */
    @TableField("seat_Num")
    private Integer seatNum ;

    /** 状态 */
    @TableField("state")
    private String state ;

    /** 创建人 */
    @TableField("created_By")
    private String createdBy ;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh-mm-ss")
    @TableField("created_Time")
    private Date createdTime ;

    /** 更新人 */
    @TableField("updated_By")
    private String updatedBy ;

    /** 更新时间 */
    @TableField("updated_Time")
    private Date updatedTime ;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getDepDate() {
        return depDate;
    }

    public void setDepDate(Date depDate) {
        this.depDate = depDate;
    }

    public String getDepPosition() {
        return depPosition;
    }

    public void setDepPosition(String depPosition) {
        this.depPosition = depPosition;
    }

    public String getDepDetail() {
        return depDetail;
    }

    public void setDepDetail(String depDetail) {
        this.depDetail = depDetail;
    }

    public String getDesPosition() {
        return desPosition;
    }

    public void setDesPosition(String desPosition) {
        this.desPosition = desPosition;
    }

    public String getDesDetail() {
        return desDetail;
    }

    public void setDesDetail(String desDetail) {
        this.desDetail = desDetail;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getWXNum() {
        return WXNum;
    }

    public void setWXNum(String WXNum) {
        this.WXNum = WXNum;
    }

    public Integer getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(Integer seatNum) {
        this.seatNum = seatNum;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
