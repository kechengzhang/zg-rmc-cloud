package com.zgtec.zgrmc.pojo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zkc
 * @description
 * @Date 2023/7/31 9:58 星期一
 * @Version 1.0
 */
@Data
@ApiModel("用户角色表")
public class UmsRoleParam {
    private Long id;
    @ApiModelProperty(value = "角色名称",required = true)
    private String name;
    @ApiModelProperty(value = "描述",required = true)
    private String description;
    @ApiModelProperty(value = "后台用户数",required = true)
    private Integer admin_count;
    @ApiModelProperty(value = "启用状态：0->禁用；1->启用数",required = true)
    private Integer status;
    @ApiModelProperty(value = "排序",required = true)
    private Integer sort;
}
