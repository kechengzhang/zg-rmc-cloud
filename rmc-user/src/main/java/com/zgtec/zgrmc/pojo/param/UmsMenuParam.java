package com.zgtec.zgrmc.pojo.param;

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
@ApiModel("菜单")
public class UmsMenuParam {
    private Long id;
    @ApiModelProperty(value ="父级ID",required = true)
    private Long parentId;
    @ApiModelProperty(value = "菜单名称" ,required = true)
    private String title;
    @ApiModelProperty(value ="前端名称",required = true)
    private String name;
    @ApiModelProperty(value ="菜单等级",required = true)
    private Integer level;
    @ApiModelProperty(value ="菜单排序",required = true)
    private Integer sort;
    @ApiModelProperty(value ="前端图标",required = true)
    private String icon;
    @ApiModelProperty(value = "前端隐藏",required = true)
    private Integer hidden;
}
