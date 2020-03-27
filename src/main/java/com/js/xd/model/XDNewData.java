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
 * 公布信息实体类
 * @since 2020-3-18
 * @author fj
 */
@TableName("xd_newData")
public class XDNewData  implements Serializable {

        /** id */
        @TableId(value = "ID",type = IdType.AUTO)
        private Integer id ;
        /** 标题 */
        @TableField("title")
        private String title ;
        /** 内容 */
        @TableField("content")
        private String content ;
        /** 显示标识;0是1否 */
        @TableField("display")
        private String display ;
        /** 配图路径 */
        @TableField("image")
        private String image ;
        /** 重要等级;0123依次增强 */
        @TableField("level")
        private String level ;
        /** 创建人 */
        @TableField("created_By")
        private String createdBy ;
        /** 创建时间 */
        @TableField("created_Time")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @JsonFormat(pattern = "yyyy-MM-dd")
        private Date createdTime ;
        /** 更新人 */
        @TableField("updated_By")
        private String updatedBy ;
        /** 更新时间 */
        @TableField("updated_Time")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @JsonFormat(pattern = "yyyy-MM-dd")
        private Date updatedTime ;

        /** id */
        public Integer getId(){
            return this.id;
        }
        /** id */
        public void setId(Integer id){
            this.id = id;
        }
        /** 标题 */
        public String getTitle(){
            return this.title;
        }
        /** 标题 */
        public void setTitle(String title){
            this.title = title;
        }
        /** 内容 */
        public String getContent(){
            return this.content;
        }
        /** 内容 */
        public void setContent(String content){
            this.content = content;
        }
        /** 显示标识;0是1否 */
        public String getDisplay(){
            return this.display;
        }
        /** 显示标识;0是1否 */
        public void setDisplay(String display){
            this.display = display;
        }
        /** 配图路径 */
        public String getImage(){
            return this.image;
        }
        /** 配图路径 */
        public void setImage(String image){
            this.image = image;
        }
        /** 重要等级;0123依次增强 */
        public String getLevel(){
            return this.level;
        }
        /** 重要等级;0123依次增强 */
        public void setLevel(String level){
            this.level = level;
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
