package com.zgtec.zgrmc.service;

import com.zgtec.zgrmc.api.Result;
import com.zgtec.zgrmc.domain.UserDto;
import com.zgtec.zgrmc.pojo.param.UmsAdminParam;
import com.zgtec.zgrmc.pojo.param.UmsAdminRoleRelationParam;

import java.util.List;

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
     * @param userName 用户名
     * @param password 密码
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

    /**
     * 添加用户
     *
     * @param umsAdminParam 用户基本信息
     * @return
     */
    int saveUser(UmsAdminParam umsAdminParam);

    /**
     * 修改用户休息
     *
     * @param umsAdminParam 用户基本信息
     * @return
     */
    int updateUser(UmsAdminParam umsAdminParam);

    /**
     * 删除用户
     * @param id 用户id
     * @return
     */
    int deleteUser(Long id);

    /**
     * 分配角色
     *
     * @param umsAdminRoleRelationParam
     * @return
     */
    int saveAdminRoleRelation(List<UmsAdminRoleRelationParam> umsAdminRoleRelationParam);
}
