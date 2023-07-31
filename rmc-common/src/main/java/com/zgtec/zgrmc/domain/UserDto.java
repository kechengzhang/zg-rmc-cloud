package com.zgtec.zgrmc.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author  zkc
 * 登录用户信息
 * Created by macro on 2020/6/19.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class UserDto {
    private Long id;
    /**
     * 用户名
     *
     */
    private String username;
    /**
     * 密码
     *
     */
    private String password;
    /**
     * 账号状态
     */
    private Integer status;
    private String clientId;
    /**
     * 角色
     */
    private List<String> roles;

}
