package com.zgtec.zgrmc.service;

import com.zgtec.zgrmc.pojo.param.UmsRoleParam;

/**
 * @author zkc
 *
 */
public interface UmsRoleService {
    /**
     * 用户角色新增
     * @param umsRoleParam  角色信息
     * @return
     */
    int saveRole(UmsRoleParam umsRoleParam);

    /**
     * 角色修改
     *
     * @param umsRoleParam
     * @return
     */
    int updateRole(UmsRoleParam umsRoleParam);

    /**
     * 角色删除
     *
     * @param id
     * @return
     */
    int deleteRole(Long id);
}
