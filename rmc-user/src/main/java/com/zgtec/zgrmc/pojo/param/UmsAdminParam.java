package com.zgtec.zgrmc.pojo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zkc
 * @description
 * @Date 2023/7/25 17:01 星期二
 * @Version 1.0
 */
@Data
@ApiModel(value = "用户新增参数")
public class UmsAdminParam {
    @ApiModelProperty(value = "用户名")
    private String userName;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "姓名")
    private String nickName;
    @ApiModelProperty(value = "备注")
    private String note;
    @ApiModelProperty(value = "帐号启用状态：0->禁用；1->启用")
    private Integer status;
}
