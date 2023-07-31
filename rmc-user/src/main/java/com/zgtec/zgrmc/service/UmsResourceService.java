package com.zgtec.zgrmc.service;

import com.zgtec.zgrmc.pojo.param.UmsResourceParam;

import java.util.List;
import java.util.Map;

/**
 * @author zkc
 *
 */
public interface UmsResourceService {
    /**
     * 资源新增
     *
     * @param umsResourceParam
     * @return
     */
    int saveResource(UmsResourceParam umsResourceParam);

    /**
     * 资源修改
     *
     * @param umsResourceParam
     * @return
     */
    int updateResource(UmsResourceParam umsResourceParam);

    /**
     * 资源删除
     * @param id
     * @return
     */
    int deleteResource(Long id);

    /**
     * 初始化资源角色关联数据
     *
     * @return
     */
    Map<String, List<String>> initResourceRolesMap();
}
