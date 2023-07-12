package com.zgtec.zgrmc.service;

import com.zgtec.zgrmc.api.Result;

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
}
