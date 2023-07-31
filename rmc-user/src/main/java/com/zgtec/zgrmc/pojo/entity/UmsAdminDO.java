package com.zgtec.zgrmc.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zkc
 * @description
 * @Date 2023/7/25 16:59 星期二
 * @Version 1.0
 */
@Data
@TableName(value = "ums_admin")
//链式编程
//@Accessors(chain = true)
public class UmsAdminDO {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "自增id")
    private Long id;
    @TableField(value = "user_name")
    @ApiModelProperty(value = "用户名")
    private String userName;
    @ApiModelProperty(value = "密码")
    @TableField(value = "password")
    private String password;
    @TableField(value = "email")
    @ApiModelProperty(value = "邮箱")
    private String email;
    @TableField(value = "nick_name")
    @ApiModelProperty(value = "姓名")
    private String nickName;
    @TableField(value = "note")
    @ApiModelProperty(value = "备注")
    private String note;
    @TableField(value = "status")
    @ApiModelProperty(value = "帐号启用状态：0->禁用；1->启用")
    private Integer status;
}
