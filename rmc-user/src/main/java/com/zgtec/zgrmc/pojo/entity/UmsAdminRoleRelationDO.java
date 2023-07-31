package com.zgtec.zgrmc.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author zkc
 * @description
 * @Date 2023/7/31 13:43 星期一
 * @Version 1.0
 */
@Data
@TableName(value = "ums_menu")
public class UmsAdminRoleRelationDO {
    @TableField("admin_id")
    private Long adminId;
    @TableField("role_id")
    private Long roleId;
}
