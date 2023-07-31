package com.zgtec.zgrmc.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zkc
 * @description
 * @Date 2023/7/31 11:51 星期一
 * @Version 1.0
 */
@Data
@TableName(value = "ums_resource")
public class UmsResourceDO {
    private Long id;
    @TableField(value = "name")
    @ApiModelProperty("资源名称")
    private String name;
    @TableField(value = "url")
    @ApiModelProperty("资源URL")
    private String url;
    @TableField(value = "description")
    @ApiModelProperty("描述")
    private String description;
    @TableField(value = "category_id")
    @ApiModelProperty("资源分类ID")
    private Long categoryId;
}
