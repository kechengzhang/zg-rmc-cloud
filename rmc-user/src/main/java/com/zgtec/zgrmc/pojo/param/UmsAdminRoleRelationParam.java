package com.zgtec.zgrmc.pojo.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author zkc
 * @description
 * @Date 2023/7/31 13:45 星期一
 * @Version 1.0
 */
@Data
@ApiModel("")
public class UmsAdminRoleRelationParam {
    private Long adminId;
    private Long roleId;
}
