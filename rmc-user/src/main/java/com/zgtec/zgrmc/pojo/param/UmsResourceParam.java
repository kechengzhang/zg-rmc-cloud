package com.zgtec.zgrmc.pojo.param;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zkc
 * @description
 * @Date 2023/7/31 11:51 星期一
 * @Version 1.0
 */
@Data
public class UmsResourceParam {
    private Long id;
    @ApiModelProperty(value = "资源名称",required = true)
    private String name;
    @ApiModelProperty(value ="资源URL",required = true)
    private String url;
    @ApiModelProperty(value = "描述",required = true)
    private String description;
    @ApiModelProperty(value = "资源分类ID",required = true)
    private Long categoryId;
}
