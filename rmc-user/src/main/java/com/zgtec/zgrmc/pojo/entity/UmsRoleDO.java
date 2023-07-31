package com.zgtec.zgrmc.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zkc
 * @description
 * @Date 2023/7/31 10:07 星期一
 * @Version 1.0
 */
@ApiModel("用户角色")
@Data
@TableName(value = "ums_role")
public class UmsRoleDO {
    private Long id;
    @ApiModelProperty(value = "角色名称",required = true)
    @TableField(value = "name")
    private String name;
    @ApiModelProperty(value = "描述",required = true)
    @TableField(value = "description")
    private String description;
    @ApiModelProperty(value = "后台用户数",required = true)
    @TableField(value = "admin_count")
    private Integer adminCount;
    @ApiModelProperty(value = "启用状态：0->禁用；1->启用数",required = true)
    @TableField(value = "status")
    private Integer status;
    @ApiModelProperty(value = "排序",required = true)
    @TableField(value = "sort")
    private Integer sort;
}
