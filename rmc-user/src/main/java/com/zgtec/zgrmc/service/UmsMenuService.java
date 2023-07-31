package com.zgtec.zgrmc.service;

import com.zgtec.zgrmc.pojo.param.UmsMenuParam;

/**
 * @author zkc
 *
 */
public interface UmsMenuService {
    /**
     * 菜单新增
     * @param umsMenuParam
     * @return
     */
    int saveMenu(UmsMenuParam umsMenuParam);

    /**
     * 菜单修改
     * @param umsMenuParam
     * @return
     */
    int updateMenu(UmsMenuParam umsMenuParam);

    /**
     * 菜单删除
     * @param id
     * @return
     */
    int deleteMenu(Long id);
}
