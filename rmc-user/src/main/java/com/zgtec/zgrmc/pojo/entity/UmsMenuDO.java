package com.zgtec.zgrmc.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zkc
 * @description
 * @Date 2023/7/31 11:46 星期一
 * @Version 1.0
 */
@Data
@ApiModel("菜单表")
@TableName(value = "ums_menu")
public class UmsMenuDO {
    private Long id;
    @TableField(value = "parent_id")
    @ApiModelProperty("父级ID")
    private Long parentId;
    @TableField(value = "title")
    @ApiModelProperty("菜单名称")
    private String title;
    @TableField(value = "name")
    @ApiModelProperty("前端名称")
    private String name;
    @TableField(value = "level")
    @ApiModelProperty("菜单等级")
    private Integer level;
    @TableField(value = "sort")
    @ApiModelProperty("菜单排序")
    private Integer sort;
    @TableField(value = "icon")
    @ApiModelProperty("前端图标")
    private String icon;
    @TableField(value = "hidden")
    @ApiModelProperty("前端隐藏")
    private Integer hidden;
}
