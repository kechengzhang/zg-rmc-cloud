package com.zgtec.zgrmc.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zgtec.zgrmc.domain.UserDto;
import com.zgtec.zgrmc.pojo.dto.RoleDTO;
import com.zgtec.zgrmc.pojo.entity.UmsAdminDO;
import com.zgtec.zgrmc.pojo.param.UmsAdminParam;
import com.zgtec.zgrmc.pojo.param.UmsAdminRoleRelationParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zkc
 * @description
 * @Date 2023/7/23 16:43 星期日
 * @Version 1.0
 */
@Mapper
public interface UmsAdminDAO extends BaseMapper<UmsAdminDO> {
    /**
     * 获取用户详细信息
     *
     * @param userName 用户名
     * @return
     */
    UserDto queryUserDetail(@Param("userName")String userName);

    /**
     *获取用户角色信息
     *
     * @param userName 用户名
     * @return
     */
    List<RoleDTO> loadUserByUsername(@Param("userName") String userName);

    /**
     * 用户删除
     * @param id 用户id
     * @return
     */
    int deleteUser(@Param("id")Long id);

    /**
     * 分配角色
     *
     * @param umsAdminRoleRelationParam
     * @return
     */
    int saveAdminRoleRelation(@Param("umsAdminRoleRelationParam") List<UmsAdminRoleRelationParam> umsAdminRoleRelationParam);

    /**
     * 获取用户角色
     * @param userId
     * @return
     */
    List<String>getUserRole(@Param("userId") Long userId);
}
