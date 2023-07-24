package com.zgtec.zgrmc.dao;

import com.zgtec.zgrmc.domain.UserDto;
import com.zgtec.zgrmc.pojo.dto.RoleDTO;

import java.util.List;

/**
 * @author zkc
 * @description
 * @Date 2023/7/23 16:43 星期日
 * @Version 1.0
 */
//@Repository
public interface UmsAdminDAO {
    /**
     * 获取用户详细信息
     *
     * @param userName 用户名
     * @return
     */
    UserDto queryUserDetail(String userName);

    /**
     *获取用户角色信息
     *
     * @param userName 用户名
     * @return
     */
    List<RoleDTO> loadUserByUsername(String userName);
}
