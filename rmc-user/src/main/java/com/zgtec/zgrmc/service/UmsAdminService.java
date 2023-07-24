package com.zgtec.zgrmc.service;

import com.zgtec.zgrmc.api.Result;
import com.zgtec.zgrmc.domain.UserDto;

/**
 * @author  zkc
 *
 * @date 2023-04-07
 *
 */
public interface UmsAdminService {
    /**
     *
     * 登录
     * @param userName
     * @param password
     * @return
     */
    Result login(String userName,String password);

    /**
     * 根据用户名获取用户信息
     *
     * @param userName 用户名
     * @return
     */
    UserDto loadUserByUsername(String userName);
}
