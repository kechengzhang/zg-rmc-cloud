package com.zgtec.zgrmc.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author zkc
 * @description
 * @Date 2023/4/7 13:36 星期五
 * @Version 1.0
 */
@Data
public class UmsAdminLoginDTO {
    @NotEmpty
    @ApiModelProperty(value = "用户名", required = true)
    private String userName;
    @NotEmpty
    @ApiModelProperty(value = "密码", required = true)
    private String password;
}

